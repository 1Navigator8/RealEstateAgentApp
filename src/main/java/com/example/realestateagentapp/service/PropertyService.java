package com.example.realestateagentapp.service;

import com.example.realestateagentapp.entity.Property;
import com.example.realestateagentapp.entity.PropertyDescription;
import com.example.realestateagentapp.exception.AgentException;
import jakarta.xml.bind.PropertyException;

import java.util.List;

public interface PropertyService {
    public Property saveProperty(Integer agentId, Property property)throws PropertyException, AgentException;
    public Property updateProperty(Integer propId,Property property,Integer brokerId)throws PropertyException,AgentException;
    public Property deleteProperty(Integer propId)throws PropertyException;
    public Property viewProperty(Integer propId)throws PropertyException;
    public List<Property> listAllProperty()throws PropertyException;
    public List<Property> listPropertyBydiscription(PropertyDescription description)throws PropertyException;

}
