package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.Profile;
import com.group3.camping_project.repository.IProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileImpl implements IProfileService {
    @Autowired
    IProfileRepo iProfileRepo;

    @Override
    public List<Profile> getAllProfiles() {
        return iProfileRepo.findAll();
    }

    @Override
    public Profile getProfileById(int id) {
        return iProfileRepo.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + id));
    }

    @Override
    public Profile createProfile(Profile profile) {
        return iProfileRepo.save(profile);
    }

    @Override
    public Profile updateProfile(int id, Profile updatedProfile) {
        Profile existingProfile = getProfileById(id);
        existingProfile.setGender(updatedProfile.getGender());
        existingProfile.setBio(updatedProfile.getBio());
        existingProfile.setProfileImage(updatedProfile.getProfileImage());
        return iProfileRepo.save(existingProfile);
    }

    @Override
    public void deleteProfile(int id) {
        Profile existingProfile = getProfileById(id);
        iProfileRepo.delete(existingProfile);
    }
}


