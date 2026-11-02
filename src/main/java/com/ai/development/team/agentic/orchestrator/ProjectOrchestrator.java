package com.ai.development.team.agentic.orchestrator;

import com.ai.development.team.agentic.agent.BusinessAnalystAgent;
import com.ai.development.team.agentic.agent.SolutionArchitectAgent;
import com.ai.development.team.agentic.dto.ArchitectureDesign;
import com.ai.development.team.agentic.dto.BusinessAnalysis;
import com.ai.development.team.agentic.dto.ProjectDesignResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class ProjectOrchestrator {
    private final BusinessAnalystAgent businessAnalystAgent;
    private final SolutionArchitectAgent solutionArchitectAgent;

    public ProjectOrchestrator(
            BusinessAnalystAgent businessAnalystAgent,
            SolutionArchitectAgent solutionArchitectAgent) {

        this.businessAnalystAgent = businessAnalystAgent;
        this.solutionArchitectAgent = solutionArchitectAgent;
    }

    public ProjectDesignResponse execute(String requirement)
            throws JsonProcessingException {

        System.out.println("Starting AI project workflow");

        // Step 1: Business analysis
        BusinessAnalysis analysis =
                businessAnalystAgent.analyze(requirement);

        // Step 2: Solution architecture
        ArchitectureDesign architecture =
                solutionArchitectAgent.design(analysis);

        System.out.println("AI project workflow completed");

        return new ProjectDesignResponse(analysis, architecture);
    }
}
