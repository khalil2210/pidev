package com.group3.camping_project.controller;

import com.group3.camping_project.service.equipement_service.SentimentAnalyzer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SentimentController {

    @GetMapping("/sentiment")
    public String getSentiment(@RequestParam String text) {
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        return sentimentAnalyzer.getSentiment(text);
    }

}
