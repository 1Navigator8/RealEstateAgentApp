package com.example.realestateagentapp.service;

import com.example.realestateagentapp.entity.Agent;
import com.example.realestateagentapp.exception.AgentException;

import java.util.List;

public interface AgentService {
    public Agent saveAgent(Agent agent) throws AgentException;
    public Agent editAgent(Integer agentId,Agent agent) throws AgentException;
    public Agent removeAgent(Integer agentId)throws AgentException;
    public Agent viewAgent(Integer agentId)throws AgentException;
    public List<Agent> viewAllAgents()throws AgentException;
}
