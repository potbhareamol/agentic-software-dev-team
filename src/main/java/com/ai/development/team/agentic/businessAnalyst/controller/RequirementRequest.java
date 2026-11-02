package com.ai.development.team.agentic.businessAnalyst.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequirementRequest (
        @NotBlank(message = "Requirement cannot be empty")
        @Size(max = 5000, message = "Requirement is too long")
        String requirement
) {
}
