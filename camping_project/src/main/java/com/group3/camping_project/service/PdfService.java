package com.group3.camping_project.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PdfService {

    public void createPdf(String filename, List<String> contents) throws IOException {
        // Create a new document
        PDDocument document = new PDDocument();

        // Add a new page
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the page
        PDType1Font font = PDType1Font.HELVETICA_BOLD;
        int fontSize = 12;
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(font, fontSize);
        int y = 700;
        for (String content : contents) {
            contentStream.beginText();
            contentStream.newLineAtOffset(100, y);
            contentStream.showText(content);
            contentStream.endText();
            y -= 20;
        }
        contentStream.close();

        // Save the document
        document.save(filename);

        // Close the document
        document.close();
    }
}
