package com.ai.development.team.agentic.businessAnalyst.controller;

import java.util.List;

public record RequirementAnalysis (
        List<String> functionalRequirements,

        List<String> nonFunctionalRequirements,

        List<String> acceptanceCriteria,

        List<String> assumptions,

        List<String> openQuestions
){
}
