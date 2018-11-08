package com.QROKproject.controller;

import com.QROKproject.dto.AuthorDTO;
import com.QROKproject.model.Author;
import com.QROKproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public String getHomePage() {

        ModelAndView mv = new ModelAndView("home");

        return "/home";
    }

    @GetMapping("/author/info/short/{id}")
    public String getAuthorInfo(@PathVariable("id") int id) {

        ModelAndView mv = new ModelAndView("author");

        AuthorDTO authorDTO = new AuthorDTO(authorService.get(id));

        mv.addObject("authorDTO", authorDTO);

        return "/author";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @ModelAttribute("authors")
    public List<Author> populateTypes() {
        return authorService.getAll();
    }
}
