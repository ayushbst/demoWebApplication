package com.example.demoWebApplication.bootstrap;

import com.example.demoWebApplication.domain.Author;
import com.example.demoWebApplication.domain.Books;
import com.example.demoWebApplication.repositories.AuthorRepository;
import com.example.demoWebApplication.repositories.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BooksRepository booksRepository;

    public BootStrapData(AuthorRepository authorRepository, BooksRepository booksRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ayush = new Author("Ayush", "Srivastava");
        Books book1 = new Books("Book1", "1234");
        ayush.getBooks().add(book1);
        book1.getAuthors().add(ayush);
        authorRepository.save(ayush);
        booksRepository.save(book1);

        Author aditya = new Author("Aditya", "Singh");
        Books book2 = new Books("Book2", "12345");
        aditya.getBooks().add(book2);
        book2.getAuthors().add(aditya);
        authorRepository.save(aditya);
        booksRepository.save(book2);

        System.out.println("Started BootStrap");
        System.out.println("Number of books : " + booksRepository.count());
    }
}
