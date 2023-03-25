package com.group3.camping_project.service.user_management;


import com.group3.camping_project.entities.enums.Gender;
import com.group3.camping_project.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class UserDTO {
    private int id;
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number should have 10 digits")
    private String phoneNumber;

    //@NotBlank(message = "Gender is required")
    private Gender gender;

    //@NotBlank(message = "Role is required")
    private Role role;

    private Date creationDate ;
    private Date updateDate ;

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

