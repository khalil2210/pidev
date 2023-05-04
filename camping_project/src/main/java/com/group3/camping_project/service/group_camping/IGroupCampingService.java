package com.group3.camping_project.service.group_camping;

import com.group3.camping_project.entities.GroupCamping;
import com.group3.camping_project.entities.User;

import java.util.List;

public interface IGroupCampingService {

    List<GroupCamping> listGroupCamping();

    public GroupCamping addGroupCamping (GroupCamping groupCamping);

    public GroupCamping updateGroupCamping (int id ,GroupCamping updategroupCamping);
    public GroupCamping updateGroupCamping1(GroupCamping updategroupCamping) ;

    GroupCamping deleteGroupCamping(int id);

    public  GroupCamping retrievbyidGpCamping(int id);



    List<GroupCamping> retrievByDestinationGpCamping(String destination);


    public List<User> getGroupmembers (int groupId);

    public void addUserToGroup(int userId, int groupId);

    public void removeUserOfGroup(int userId, int groupId);


}
