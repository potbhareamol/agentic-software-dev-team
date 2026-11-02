package com.ai.development.team.agentic.businessAnalyst.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class RequirementAnalysisTools {

    @Tool(description = """
                    Validates whether a business requirement contains
                    sufficient information to start development.
                    Use this tool when a requirement needs validation.
            """)
    public String validateRequirement(String requirement) {

        log.info("Validate requirement tool called");
        if (requirement == null || requirement.isBlank()) {
            return "Invalid requirement: Requirement is empty";
        }

        if (requirement.length() < 30) {
            return "Requirement is too short. More details required.";
        }

        return "Requirement contains sufficient initial detail.";
    }

    @Tool(description = """
        Identify missing business and technical information
        in the supplied requirement. Use this tool when
        analysing requirement completeness.
        """)
    public List<String> checkMissingInformation() {
        log.info("checkMissingInformation tool called");
        return List.of(
                "Authentication mechanism not specified",
                "Employee data retention policy not specified",
                "Expected API response time not specified",
                "Role-based authorization details missing"
        );
    }

    @Tool(description = """
        Generate acceptance criteria based on the supplied
        business requirement.
        """)
    public List<String> generateAcceptanceCriteria() {

        log.info("TOOL EXECUTED: generateAcceptanceCriteria");
        return List.of(
                "Admin can create an employee",
                "Admin can update employee details",
                "Authorized users can search employees",
                "Unauthorized users cannot access employee data"
        );
    }
}
