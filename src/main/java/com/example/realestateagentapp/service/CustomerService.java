package com.example.realestateagentapp.service;

import com.example.realestateagentapp.entity.Customer;
import com.example.realestateagentapp.exception.CustomerException;

import java.util.List;

public interface CustomerService {
    public Customer addCoustomer(Customer customer);
    public Customer editCoustomer(Integer custId,Customer customer) throws CustomerException;
    public Customer removeCoustomer(Integer custId) throws CustomerException;
    public Customer viewCoustomer(Integer custId) throws CustomerException;
    public List<Customer> viewAllCoustomer()throws CustomerException;
}
