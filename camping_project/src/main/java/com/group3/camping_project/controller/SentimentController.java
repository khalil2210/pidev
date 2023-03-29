package com.group3.camping_project.controller;

import com.group3.camping_project.service.SentimentAnalyzer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentimentController {

    @GetMapping("/sentiment")
    public String getSentiment(@RequestParam String text) {
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        return sentimentAnalyzer.getSentiment(text);
    }

}
