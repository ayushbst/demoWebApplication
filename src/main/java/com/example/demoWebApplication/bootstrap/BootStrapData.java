package com.example.demoWebApplication.bootstrap;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demoWebApplication.domain.Author;
import com.example.demoWebApplication.domain.Books;
import com.example.demoWebApplication.domain.Publisher;
import com.example.demoWebApplication.repositories.AuthorRepository;
import com.example.demoWebApplication.repositories.BooksRepository;
import com.example.demoWebApplication.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BooksRepository booksRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BooksRepository booksRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ayush = new Author("Ayush", "Srivastava");
        Books book1 = new Books("Book1", "1234");
        Publisher publisher1 = new Publisher("P Books", "10 street", "Bangalore", "Karnataka", "560100");
        publisherRepository.save(publisher1);

        ayush.getBooks().add(book1);
        book1.getAuthors().add(ayush);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(ayush);
        booksRepository.save(book1);
        publisherRepository.save(publisher1);


        Author aditya = new Author("Aditya", "Singh");
        Books book2 = new Books("Book2", "12345");

        aditya.getBooks().add(book2);
        book2.getAuthors().add(aditya);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);
        authorRepository.save(aditya);
        booksRepository.save(book2);
        publisherRepository.save(publisher1);


        System.out.println("Started BootStrap");
        System.out.println("Number of books : " + booksRepository.count());
        System.out.println("Number of publisher : " + publisher1.getBooks().size());
    }
}
