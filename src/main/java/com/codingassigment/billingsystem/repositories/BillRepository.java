package com.codingassigment.billingsystem.repositories;

import com.codingassigment.billingsystem.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    boolean existsByName(String name);

    Optional<Bill> findById(Integer id);
}
