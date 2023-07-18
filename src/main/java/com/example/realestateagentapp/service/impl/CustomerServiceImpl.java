package com.example.realestateagentapp.service.impl;

import com.example.realestateagentapp.entity.Customer;
import com.example.realestateagentapp.exception.CustomerException;
import com.example.realestateagentapp.repository.CustomerRepository;
import com.example.realestateagentapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository custRepo;

    @Override
    public Customer addCoustomer(Customer customer) {
        // TODO Auto-generated method stub
        return custRepo.save(customer);
    }

    @Override
    public Customer editCoustomer(Integer custId, Customer customer) throws CustomerException {
        Optional<Customer> opt=custRepo.findById(custId);
        if(opt.isEmpty()) {
            throw new CustomerException("Customer not exist with this Id: "+custId);
        }else {
            Customer customer1=opt.get();
            customer1.setName(customer.getName());
            custRepo.save(customer1);
            return customer1;
        }

    }

    @Override
    public Customer removeCoustomer(Integer custId) throws CustomerException {
        Optional<Customer> opt=custRepo.findById(custId);
        if(opt.isEmpty()) {
            throw new CustomerException("Customer not exist with this Id: "+custId);
        }else {
            Customer customer1=opt.get();

            custRepo.delete(customer1);
            return customer1;
        }


    }

    @Override
    public Customer viewCoustomer(Integer custId) throws CustomerException {
        // TODO Auto-generated method stub
        return custRepo.findById(custId).orElseThrow(()->new CustomerException("Customer not exist with this Id: "+custId));
    }

    @Override
    public List<Customer> viewAllCoustomer() throws CustomerException {
        List<Customer> list=custRepo.findAll();
        if(list.isEmpty())throw new CustomerException("Customer not exist");
        return list;
    }
}
