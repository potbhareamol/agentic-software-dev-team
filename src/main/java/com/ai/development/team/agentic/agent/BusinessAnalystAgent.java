package com.ai.development.team.agentic.agent;

import com.ai.development.team.agentic.dto.BusinessAnalysis;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class BusinessAnalystAgent {
    private final ChatClient chatClient;

    public BusinessAnalystAgent(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public BusinessAnalysis analyze(String requirement) {

        System.out.println("Executing Business Analyst Agent");

        return chatClient.prompt()
                .system("""
                    You are an experienced Business Analyst.

                    Your responsibilities:
                    1. Understand business requirements.
                    2. Identify functional requirements.
                    3. Identify non-functional requirements.
                    4. Identify assumptions.
                    5. Identify missing information and open questions.
                    6. Generate testable acceptance criteria.

                    Do not invent business decisions.
                    Clearly distinguish assumptions from confirmed requirements.
                    Return a structured business analysis.
                    """)
                .user(requirement)
                .call()
                .entity(BusinessAnalysis.class);
    }
}
