package com.example.realestateagentapp.service.impl;


import com.example.realestateagentapp.entity.Agent;
import com.example.realestateagentapp.exception.AgentException;
import com.example.realestateagentapp.repository.AgentRepository;
import com.example.realestateagentapp.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepo;

    @Override
    public Agent saveAgent(Agent agent) throws AgentException {
        // TODO Auto-generated method stub
        return agentRepo.save(agent);
    }

    @Override
    public Agent editAgent(Integer agentId, Agent agent) throws AgentException {
        Optional<Agent> opt = agentRepo.findById(agentId);
        if (opt.isEmpty()) {
            throw new AgentException("No Agent Exist from this agentId: " + agentId);
        } else {
            Agent agent1 = opt.get();
            agent1.setName(agent.getName());
            agentRepo.save(agent1);
            return agent1;
        }
    }

    @Override
    public Agent removeAgent(Integer agentId) throws AgentException {
        Optional<Agent> opt = agentRepo.findById(agentId);
        if (opt.isEmpty()) {
            throw new AgentException("No Agent Exist from this agentId: " + agentId);
        } else {
            Agent agent = opt.get();
            agentRepo.delete(agent);
            return agent;
        }
    }

    @Override
    public Agent viewAgent(Integer agentId) throws AgentException {
        // TODO Auto-generated method stub
        return agentRepo.findById(agentId).orElseThrow(() -> new AgentException("No Agent Found"));
    }

    @Override
    public List<Agent> viewAllAgents() throws AgentException {
        List<Agent> list=agentRepo.findAll();
        if (list.isEmpty())new AgentException("No Agent Found");
        return list;
    }


}
