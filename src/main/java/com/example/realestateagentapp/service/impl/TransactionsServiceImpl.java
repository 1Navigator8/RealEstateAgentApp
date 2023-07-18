package com.example.realestateagentapp.service.impl;

import com.example.realestateagentapp.entity.Customer;
import com.example.realestateagentapp.entity.Property;
import com.example.realestateagentapp.entity.Transactions;
import com.example.realestateagentapp.repository.TransactionsRepository;
import com.example.realestateagentapp.service.TransactionsService;
import jakarta.xml.bind.PropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepo;
    @Override
    public Transactions addTransactions(Property property, Customer customer) throws PropertyException {
        if (!property.isStatus()) {
            throw new PropertyException("property Already Sold to customer with property id: " + property.getPropId());
        } else {
            Transactions transactions = new
                    Transactions(LocalDate.now(), property.getOfferCost(), customer, property);
            Transactions transactions1 = transactionsRepo.save(transactions);
            customer.getProperties().add(property);
            property.setStatus(false);
            return transactions1;
        }

    }

    @Override
    public List<Transactions> viewAllTransactions() {
        return null;
    }
}
