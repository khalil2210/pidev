package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProfileService {
    List<Profile> getAllProfiles();

    Profile getProfileById(int id);

    Profile createProfile(Profile profile);

    Profile updateProfile(int id, Profile updatedProfile);

    void deleteProfile(int id);
}
