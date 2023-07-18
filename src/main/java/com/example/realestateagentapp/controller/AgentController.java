package com.example.realestateagentapp.controller;

import com.example.realestateagentapp.entity.Agent;
import com.example.realestateagentapp.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.realestateagentapp.entity.Agent;
import com.example.realestateagentapp.service.AgentService;
import java.util.List;

@RestController
@RequestMapping("/users")

public class AgentController {
    @Autowired
    private AgentService agentService;
    @PostMapping("/agent")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Agent addAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }
    @PatchMapping("/agent/{agentId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Agent UpdateAgentHandler(@PathVariable  Integer agentId,@RequestBody Agent agent) {
        return agentService.editAgent(agentId,agent);
    }
    @DeleteMapping("/agent/{agentId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Agent deleteAgentHandler(@PathVariable Integer agentId) {
        return agentService.removeAgent(agentId);
    }
    @GetMapping("/agent/{agentId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Agent viewAgentByID(@PathVariable Integer agentId) {
        return agentService.viewAgent(agentId);
    }
    @GetMapping("/agents")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Agent> viewAllAgents(){
        return agentService.viewAllAgents();
    }
}
