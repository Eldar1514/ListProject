package com.example.Test.TestController;


import com.example.Test.ListRepo;
import com.example.Test.Model.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class GreetingController {

    @Autowired
    private ListRepo listRepo;

    @GetMapping("/")
    public String list(Model model) {
        Iterable<List>lists=listRepo.findAll();
        model.addAttribute("lists",lists);
        model.addAttribute("list", new List());
        return "home";
    }

    @PostMapping("/")
    public String listAdd(@Valid @ModelAttribute List list, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "home";

        listRepo.save(list);
        return "redirect:/";
    }


}


