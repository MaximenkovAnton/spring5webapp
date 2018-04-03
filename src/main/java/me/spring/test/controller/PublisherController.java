package me.spring.test.controller;

import lombok.AllArgsConstructor;
import me.spring.test.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class PublisherController {
    private AuthorRepository authorRepository;

    @RequestMapping("/publishers")
    public String getBook(Model model){
        model.addAttribute("publishers", authorRepository.findAll());
        return "publishers";
    }
}
