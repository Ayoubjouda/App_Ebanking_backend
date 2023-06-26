package org.sid.ebankingbackend.repositories;

import org.sid.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepositoriy extends JpaRepository<Customer,Long> {
    List<Customer> findByNameContains(String keyword);
}
