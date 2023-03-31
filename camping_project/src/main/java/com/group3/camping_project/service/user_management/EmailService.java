//package com.group3.camping_project.service.user_management;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String fromEmail;
//
//    public void sendVerificationEmail(String toEmail, String verificationToken) throws MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(toEmail);
//        helper.setFrom(fromEmail);
//        helper.setSubject("Verify your email address");
//
//        String verifyLink = "http://localhost:8080/verify?token=" + verificationToken;
//        String emailBody = "<p>Click the link below to verify your email address:</p>"
//                + "<p><a href=\"" + verifyLink + "\">" + verifyLink + "</a></p>";
//
//        helper.setText(emailBody, true);
//
//        mailSender.send(message);
//    }
//}
