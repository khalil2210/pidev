package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.GroupCamping;
import com.group3.camping_project.repository.IGroupCampingRepo;
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
    public GroupCamping addGroupCamping (GroupCamping groupCamping) {
        return iGroupCampingRepo.save(groupCamping);
    }

    @Override
    public GroupCamping updateGroupCamping (GroupCamping groupCamping)
    {
        return iGroupCampingRepo.save(groupCamping);
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

}
