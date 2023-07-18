package com.example.realestateagentapp.repository;

import com.example.realestateagentapp.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
