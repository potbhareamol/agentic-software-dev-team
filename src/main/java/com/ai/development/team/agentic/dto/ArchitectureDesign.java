package com.ai.development.team.agentic.dto;

import java.util.List;

public record ArchitectureDesign(
        String architectureOverview,
        List<String> services,
        List<String> apiEndpoints,
        List<String> dataEntities,
        List<String> technologyChoices,
        List<String> architecturalRisks
) {
}
