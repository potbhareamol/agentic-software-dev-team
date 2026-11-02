package com.ai.development.team.agentic.controller;

import com.ai.development.team.agentic.dto.ProjectDesignResponse;
import com.ai.development.team.agentic.orchestrator.ProjectOrchestrator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectOrchestrator orchestrator;

    public ProjectController(ProjectOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping("/design")
    public ProjectDesignResponse design(
            @RequestBody String requirement)
            throws JsonProcessingException {

        return orchestrator.execute(requirement);
    }
}
