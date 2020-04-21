package com.example.demoWebApplication.repositories;

import com.example.demoWebApplication.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
