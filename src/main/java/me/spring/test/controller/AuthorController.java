package me.spring.test.controller;

import lombok.AllArgsConstructor;
import me.spring.test.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AuthorController {
    private AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getBook(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
