package com.example.realestateagentapp.repository;

import com.example.realestateagentapp.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer>{
}
