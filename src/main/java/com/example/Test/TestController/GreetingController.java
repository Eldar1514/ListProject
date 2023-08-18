package com.example.Test.TestController;


import com.example.Test.ExcelExportService;
import com.example.Test.ListRepo;
import com.example.Test.Model.Entry;
import com.example.Test.Model.Entry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GreetingController {
    @Autowired
    private ListRepo listRepo;

    @Autowired
    private ExcelExportService excelExportService;

    @GetMapping("/")
    public String list(Model model) {
        Iterable<Entry> lists = listRepo.findAll();
        model.addAttribute("lists", lists);
        model.addAttribute("list", new Entry());
        return "home";
    }

    @PostMapping("/")
    public String listAdd(@Valid @ModelAttribute Entry list, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "home";

        listRepo.save(list);
        return "redirect:/";
    }

    @RequestMapping("/export")
    @ResponseBody
    public String exportToExcel() {
        List<Entry> entries = (List<Entry>) listRepo.findAll();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(entries);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @GetMapping("/search")
    public String findByKeyword (@RequestParam ("name") String keyword,Model model){
        List<Entry>searchResults =listRepo.findByNameContainingOrSurnameContainingOrProfessionContaining(keyword,keyword,keyword);
        model.addAttribute("searchResults",searchResults);
        return "search";
    }


    @GetMapping("/searchByAge")
    public String findByAge (@RequestParam ("name") String age,Model model){
        List<Entry>searchResults = listRepo.findByAgeContaining(age);
        model.addAttribute("searchResults",searchResults);
        return "searchByAge";
    }
}

