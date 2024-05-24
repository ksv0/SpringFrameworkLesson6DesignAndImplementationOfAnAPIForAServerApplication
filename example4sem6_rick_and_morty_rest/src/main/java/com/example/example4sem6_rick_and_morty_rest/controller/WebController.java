package com.example.example4sem6_rick_and_morty_rest.controller;

import com.example.example4sem6_rick_and_morty_rest.model.Page;
import com.example.example4sem6_rick_and_morty_rest.service.charactermanagementservice.IManagementService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class WebController {

    private IManagementService service;

    @GetMapping("/")
    public String index() {
        service.reloadCharacters();
        return "index";
    }

    @GetMapping("/characters")
    public String characters() {
        return "redirect:/characters/1";
    }

    @GetMapping("/characters/{pageNumber}")
    public String characters(@PathVariable int pageNumber, Model model) {
        pageNumber = service.check(pageNumber);
        Page page = service.getPageAt(pageNumber);

        model.addAttribute("Page", page);
        model.addAttribute("CardList", page.getCards());
        model.addAttribute("characters", page.getCards());
        return "characters";
    }
}
