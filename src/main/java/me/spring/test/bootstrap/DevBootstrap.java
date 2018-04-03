package me.spring.test.bootstrap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.spring.test.model.Author;
import me.spring.test.model.Book;
import me.spring.test.model.Publisher;
import me.spring.test.repositories.AuthorRepository;
import me.spring.test.repositories.BookRepository;
import me.spring.test.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;

    private void initEric() {
        Author eric = new Author("Eric", "Evans");
        Publisher harper = initPublisherByFirstNameAndLastName("Harper", "Collins");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        saveInRepositories(eric, ddd, harper);
    }

    private Publisher initPublisherByFirstNameAndLastName(String firstName, String lastName) {
        Publisher publisher = new Publisher();
        publisher.setFirstName(firstName);
        publisher.setLastName(lastName);
        return publisher;
    }

    private void initRod() {
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = initPublisherByNickName("Worx");
        Book noEJB = new Book("J2EE development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        saveInRepositories(rod, noEJB, worx);
    }

    private Publisher initPublisherByNickName(String nick) {
        Publisher publisher = new Publisher();
        publisher.setNick(nick);
        return publisher;
    }

    private void saveInRepositories(Author author, Book book, Publisher publisher){
        authorRepository.save(author);
        publisherRepository.save(publisher);
        bookRepository.save(book);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initEric();
        initRod();
    }
}
