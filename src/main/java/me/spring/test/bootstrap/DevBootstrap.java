package me.spring.test.bootstrap;

import lombok.AllArgsConstructor;
import me.spring.test.model.Author;
import me.spring.test.model.Book;
import me.spring.test.repositories.AuthorRepository;
import me.spring.test.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private void initEric() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        saveInRepositories(eric, ddd);
    }

    private void initRod() {
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "23444", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        saveInRepositories(rod, noEJB);
    }

    private void saveInRepositories(Author author, Book book){
        authorRepository.save(author);
        bookRepository.save(book);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initEric();
        initRod();
    }
}
