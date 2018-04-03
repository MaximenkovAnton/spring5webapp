package me.spring.test.controller;

import lombok.AllArgsConstructor;
import me.spring.test.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class PublisherController {
    private PublisherRepository publisherRepository;

    @RequestMapping("/publishers")
    public String getBook(Model model){
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publishers";
    }
}
