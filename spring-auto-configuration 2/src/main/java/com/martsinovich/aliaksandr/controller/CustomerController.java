package com.martsinovich.aliaksandr.controller;

import com.martsinovich.aliaksandr.entity.Customer;
import com.martsinovich.aliaksandr.repository.CustomerRepository;
import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

  private final CustomerRepository repository;

  public CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/customers")
  public Collection<Customer> getAll() {
    return repository.findAll();
  }
}
