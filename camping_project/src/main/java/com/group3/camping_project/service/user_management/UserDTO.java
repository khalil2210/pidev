package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.entities.enums.Gender;
import com.group3.camping_project.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number should have 10 digits")
    private String phoneNumber;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Role is required")
    private Role role;

//   public UserDTO(User user) {
//        this.id = user.getId();
//        this.firstName = user.getFirstName();
//        this.lastName = user.getLastName();
//        this.email = user.getEmail();
//        this.phoneNumber = user.getPhoneNumber();
//        this.gender = user.getGender();
//        this.role = user.getRole();
//        this.creationDate = user.getCreationDate();
//        this.updateDate = user.getUpdateDate();
//        this.profileImage = user.getProfileImage().getImageData();
//    }
}

