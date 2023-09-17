package com.codingassigment.billingsystem.repositories;

import com.codingassigment.billingsystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findByReferenceNo(String referenceNo);

    boolean existsByReferenceNo(String referenceNo);
}
