package com.example.demoWebApplication.repositories;

import com.example.demoWebApplication.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
