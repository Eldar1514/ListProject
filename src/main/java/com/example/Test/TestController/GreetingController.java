package com.example.Test.TestController;


import com.example.Test.ListRepo;
import com.example.Test.Model.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private ListRepo listRepo;

    @GetMapping("/")
    public String list(Model model) {
        Iterable<List>lists=listRepo.findAll();
        model.addAttribute("lists",lists);
        return "home";
    }

    @PostMapping("/")
    public String listAdd(@RequestParam String name,@RequestParam String surname,@RequestParam int age,
                          @RequestParam String profession, Model model){
        List list = new List(name,surname,age,profession);
        listRepo.save(list);
        return "redirect:/";
    }

}


