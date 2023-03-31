package com.group3.camping_project.service.user_management;


import com.group3.camping_project.controller.user_management.request.SignupRequest;
import com.group3.camping_project.entities.Role;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.entities.enums.ERole;
import com.group3.camping_project.repository.IRoleRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.repository.IVerificationTokenRepo;
import com.group3.camping_project.service.user_management.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AuthService {
    @Autowired
    private IUserRepo userRepository;
    @Autowired
    private IRoleRepo roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private IVerificationTokenRepo iVerificationTokenRepo ;

    @Autowired
    private JavaMailSender javaMailSender;

    public void insertRoles() {
        if (!roleRepository.existsByName(ERole.ROLE_USER)) {
            Role userRole = new Role(ERole.ROLE_USER);
            roleRepository.save(userRole);
        }

        if (!roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            Role adminRole = new Role(ERole.ROLE_ADMIN);
            roleRepository.save(adminRole);
        }
    }

    public void registerUser(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new BadRequestException("Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email is already in use!");
        }

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getGender(),
                signUpRequest.getPhoneNumber(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, user);
        iVerificationTokenRepo.save(verificationToken);

        // Send verification email to the user
        String verifyEmailLink = "http://localhost:8090/api/auth/verify-email?token=" + token;
        sendVerificationEmail(user.getEmail(), verifyEmailLink);
    }



//    @Bean
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("your.smtp.host");
//        mailSender.setPort(587); // or your SMTP port number
//        mailSender.setUsername("your.smtp.username");
//        mailSender.setPassword("your.smtp.password");
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//        return mailSender;
//    }






    private void sendVerificationEmail(String toEmail, String verifyEmailLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("campingProject@picloud.com");
        message.setTo(toEmail);
        message.setSubject("Verify your email address");
        message.setText("Please click the following link to verify your email address: " + verifyEmailLink);
        javaMailSender.send(message);
    }


    public void validateEmailVerificationToken(String token) {
        VerificationToken verificationToken = iVerificationTokenRepo.findByToken(token)
                .orElseThrow(() -> new BadRequestException("Invalid verification token."));

        User user = verificationToken.getUser();
        LocalDateTime expiryDate = verificationToken.getExpiryDate();

        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Verification token has expired. Please generate a new one.");
        }


        user.setEmailVerified(true);
        userRepository.save(user);
    }
}

