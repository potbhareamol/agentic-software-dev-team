package com.ai.development.team.agentic.businessAnalyst.service;

import com.ai.development.team.agentic.businessAnalyst.controller.RequirementAnalysis;
import com.ai.development.team.agentic.businessAnalyst.tools.RequirementAnalysisTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class RequirementAnalysisService {
    private final ChatClient chatClient;
    private final RequirementAnalysisTools requirementAnalysisTools;

    public RequirementAnalysisService(ChatClient.Builder builder, RequirementAnalysisTools requirementAnalysisTools) {
        this.chatClient = builder.build();
        this.requirementAnalysisTools = requirementAnalysisTools;
    }

    public RequirementAnalysis analyze(String requirement) {

        return chatClient.prompt()
                .system("""
                        You are a Business Analyst Agent.
                        
                        Your responsibility is to convert business requirements into
                        clear, actionable requirements.
                        
                        Rules:
                        
                        1. Assess whether the requirement is sufficiently detailed.
                        2. If it is ambiguous or incomplete, invoke checkMissingInformation.
                        3. If it contains sufficient information, invoke validateRequirement.
                        4. Generate acceptance criteria using the available tool.
                        5. Never silently assume missing business information.
                        6. Clearly identify assumptions and open questions.
                        """)
                .user(requirement)
                .tools(requirementAnalysisTools)
                .call()
                .entity(RequirementAnalysis.class);
    }
}
