package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.GroupCamping;
import com.group3.camping_project.entities.Profile;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IGroupCampingRepo;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupCampingImpl implements IGroupCampingService {
    @Autowired
    IGroupCampingRepo iGroupCampingRepo;

    @Override
    public List<GroupCamping> listGroupCamping()
    {
        return iGroupCampingRepo.findAll();
    }


    @Override
    public GroupCamping addGroupCamping (GroupCamping groupCamping)
    {
        return iGroupCampingRepo.save(groupCamping);
    }




    @Override
    public GroupCamping updateGroupCamping (int id, GroupCamping updategroupCamping) {
        GroupCamping existingGroupCamping = retrievbyidGpCamping(id);
        existingGroupCamping.setDescription(updategroupCamping.getDescription());
        existingGroupCamping.setDestination(updategroupCamping.getDestination());
        existingGroupCamping.setCarModel(updategroupCamping.getCarModel());
        existingGroupCamping.setCampingType(updategroupCamping.getCampingType());
        existingGroupCamping.setCreatedAt(updategroupCamping.getCreatedAt());
        existingGroupCamping.setAvailablePlaces(updategroupCamping.getAvailablePlaces());
        existingGroupCamping.setRequirements(updategroupCamping.getRequirements());

        return iGroupCampingRepo.save(existingGroupCamping);
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
