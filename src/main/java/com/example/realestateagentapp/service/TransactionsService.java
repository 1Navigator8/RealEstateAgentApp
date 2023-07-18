package com.example.realestateagentapp.service;

import com.example.realestateagentapp.entity.Customer;
import com.example.realestateagentapp.entity.Property;
import com.example.realestateagentapp.entity.Transactions;
import jakarta.xml.bind.PropertyException;

import java.util.List;

public interface TransactionsService {
    public Transactions addTransactions(Property property, Customer customer) throws PropertyException;
    public List< Transactions> viewAllTransactions();
}
