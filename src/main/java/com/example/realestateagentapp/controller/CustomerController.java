package com.example.realestateagentapp.controller;

import com.example.realestateagentapp.entity.Customer;
import com.example.realestateagentapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CustomerController {
    @Autowired
    private CustomerService custSer;

    @PostMapping("/customer")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer addCoustomer(@RequestBody Customer customer) {
        return custSer.addCoustomer(customer);
    }
    @PutMapping("/customer/{custId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer updateCoustomer(@PathVariable Integer custId,@RequestBody  Customer customer) {
        return custSer.editCoustomer(custId, customer);
    }
    @DeleteMapping("/customer/{custId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer deleteCoustomer(@PathVariable  Integer custId) {
        return custSer.removeCoustomer(custId);
    }

    @GetMapping("/customer/{custId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer viewCoustomerById(@PathVariable  Integer custId) {
        return custSer.viewCoustomer(custId);
    }
    @GetMapping("/customers")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Customer> viewAllCoustomer(){
        return custSer.viewAllCoustomer();
    }
}
