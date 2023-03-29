package com.group3.camping_project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final String apiKey = "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";
    private final String modelId = "text-davinci-003";

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        try {
            // Create a new HTTP connection to the OpenAI API
            URL url = new URL("https://api.openai.com/v1/engines/" + modelId + "/completions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Construct the JSON request body
            String jsonRequestBody = "{\"prompt\": \"" + message + "\", \"max_tokens\": 64}";

            // Send the request body
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonRequestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response JSON and return the generated text
            return parseResponse(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private String parseResponse(String jsonResponse) {
        // Parse the response JSON and return the generated text
        // Here's a simple example of how to parse the JSON using the Jackson library
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonResponse);
            JsonNode choices = node.get("choices");
            JsonNode text = choices.get(0).get("text");
            return text.asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
