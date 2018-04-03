package me.spring.test.controller;

import lombok.AllArgsConstructor;
import me.spring.test.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class BookController {
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBook(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
