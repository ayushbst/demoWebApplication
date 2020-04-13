package com.example.demoWebApplication.repositories;

import com.example.demoWebApplication.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
