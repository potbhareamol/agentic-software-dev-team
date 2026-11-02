package com.ai.development.team.agentic.businessAnalyst.controller;

import com.ai.development.team.agentic.businessAnalyst.service.RequirementAnalysisService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/analyst")
public class Controller {

    private final RequirementAnalysisService requirementAnalysisService;

    public Controller(RequirementAnalysisService requirementAnalysisService) {
        this.requirementAnalysisService = requirementAnalysisService;
    }

    @PostMapping("/analyze")
    public RequirementAnalysis analyze( @Valid @RequestBody RequirementRequest requirementRequest) {
        return requirementAnalysisService.analyze(requirementRequest.requirement());
    }
}
