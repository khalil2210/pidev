package com.group3.camping_project.controller;

import com.group3.camping_project.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @PostMapping("/pdf")
    public ResponseEntity<String> createPdf(@RequestParam("contents") List<String> contents) {
        try {
            pdfService.createPdf("example.pdf", contents);
            return ResponseEntity.ok("PDF created successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating PDF");
        }
    }
}

