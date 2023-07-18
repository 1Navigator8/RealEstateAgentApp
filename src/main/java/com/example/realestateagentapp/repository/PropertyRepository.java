package com.example.realestateagentapp.repository;

import com.example.realestateagentapp.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    public List<Property>
    findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(String config,String offer,String city,double minCost,double maxCost);
}
