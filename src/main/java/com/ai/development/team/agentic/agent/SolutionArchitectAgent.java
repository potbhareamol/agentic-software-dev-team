package com.ai.development.team.agentic.agent;

import com.ai.development.team.agentic.dto.ArchitectureDesign;
import com.ai.development.team.agentic.dto.BusinessAnalysis;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class SolutionArchitectAgent {
    private final ChatClient chatClient;
    private final ObjectMapper objectMapper;

    public SolutionArchitectAgent(
            ChatClient.Builder builder,
            ObjectMapper objectMapper) {

        this.chatClient = builder.build();
        this.objectMapper = objectMapper;
    }

    public ArchitectureDesign design(BusinessAnalysis analysis)
            throws JsonProcessingException {

        System.out.println("Executing Solution Architect Agent");

        String analysisJson = objectMapper.writeValueAsString(analysis);

        return chatClient.prompt()
                .system("""
                    You are an experienced Enterprise Solution Architect.

                    You receive business analysis from a Business Analyst.

                    Your responsibilities:
                    1. Propose an appropriate application architecture.
                    2. Identify logical services and their responsibilities.
                    3. Define important REST API endpoints.
                    4. Identify important data entities.
                    5. Recommend suitable technologies.
                    6. Identify architectural risks.

                    Consider scalability, security, availability,
                    maintainability and performance.

                    Do not treat assumptions or open questions as confirmed facts.
                    Highlight where clarification is needed.
                    Avoid unnecessary microservices.
                    """)
                .user("""
                    Prepare a solution architecture based on this business analysis:

                    %s
                    """.formatted(analysisJson))
                .call()
                .entity(ArchitectureDesign.class);
    }
}
