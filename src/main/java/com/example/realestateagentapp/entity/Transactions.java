package com.example.realestateagentapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionsId;
    private LocalDate transactionsDate;
    private double transactionsCost;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "propId")
    private Property property;

    public Transactions(LocalDate localDate, double transactionsCost, Customer customer, Property property){
        super();
        this.transactionsDate = localDate;
        this.transactionsCost =transactionsCost;
        this.customer= customer;
        this.property=property;
    }

}
