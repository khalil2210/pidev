package com.group3.camping_project.service.group_camping;

import com.group3.camping_project.entities.GroupCamping;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.Post;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IGroupCampingRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.service.user_management.exception.UserNotFoundException;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@Service
public class GroupCampingImpl implements IGroupCampingService {
    @Autowired
    IGroupCampingRepo iGroupCampingRepo;
    @Autowired
    IImageRepo iImageRepo;

    @Override
    public List<GroupCamping> listGroupCamping()
    {
        return iGroupCampingRepo.findAll();
    }


    @Override
    public GroupCamping addGroupCamping (GroupCamping groupCamping ,MultipartFile image) throws IOException {

        Image imagee = iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image.getBytes())).build());
        groupCamping.setImage(imagee);

        return iGroupCampingRepo.save(groupCamping);
    }







    @Override
    public GroupCamping updateGroupCamping ( MultipartFile image,  GroupCamping updategroupCamping) throws IOException {
        Image imagee = iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image.getBytes())).build());

        updategroupCamping.setImage(imagee);
        return iGroupCampingRepo.save(updategroupCamping);
    }
    @Override
    public GroupCamping updateGroupCamping1(GroupCamping updategroupCamping) {


        return iGroupCampingRepo.save(updategroupCamping);
    }

    @Override
    public GroupCamping deleteGroupCamping(int id)
    {
        iGroupCampingRepo.deleteById(id);
        return null;
    }


    @Override
    public  GroupCamping retrievbyidGpCamping(int id)
    {
        return iGroupCampingRepo.findById(id).get();
    }


    @Override
    public  List<GroupCamping> retrievByDestinationGpCamping(String destination)
    {
        return iGroupCampingRepo.findByDestination(destination);
    }





    @Override
    public List<User> getGroupmembers (int groupId){
        GroupCamping groupCamping = iGroupCampingRepo.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("group not found with id: " + groupId));
        return groupCamping.getGoingUsers();
    }



    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public void addUserToGroup(int userId, int groupId) {
        User user = iUserRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found with id: " + userId));

        GroupCamping groupCamping = iGroupCampingRepo.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("group camping not found with id: " + groupId));

        groupCamping.getGoingUsers().add(user);
        user.getGroupCamping().add(groupCamping);

        iGroupCampingRepo.save(groupCamping);
        iUserRepo.save(user);
    }






    @Override
    public void removeUserOfGroup(int userId, int groupId) {
        User user = iUserRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found with id: " + userId));

        GroupCamping groupCamping = iGroupCampingRepo.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("group camping not found with id: " + groupId));

        groupCamping.getGoingUsers().remove(user);
        user.getGroupCamping().remove(groupCamping);

        iGroupCampingRepo.save(groupCamping);
        iUserRepo.save(user);
    }









}
