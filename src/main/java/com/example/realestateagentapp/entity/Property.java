package com.example.realestateagentapp.entity;
import lombok.*;
import jakarta.persistence.*;


@Data
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propId;

    private String configuration;
    private String offerType;
    private double offerCost;
    private double areaSqft;
    private String address;
    private String street;
    private String city;
    private boolean status;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bid")
    private Agent agent;

}
