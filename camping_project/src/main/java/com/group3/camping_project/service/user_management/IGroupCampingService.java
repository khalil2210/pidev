package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.GroupCamping;

import java.util.List;

public interface IGroupCampingService {

    List<GroupCamping> listGroupCamping();

    public GroupCamping addGroupCamping (GroupCamping groupCamping);

    public GroupCamping updateGroupCamping (int id ,GroupCamping updategroupCamping);

    GroupCamping deleteGroupCamping(int id);

    public  GroupCamping retrievbyidGpCamping(int id);
}
