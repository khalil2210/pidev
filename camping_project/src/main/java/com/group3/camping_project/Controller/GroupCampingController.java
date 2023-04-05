package com.group3.camping_project.Controller;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.user_management.IGroupCampingService;
import com.group3.camping_project.entities.GroupCamping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/GroupCamping")
public class GroupCampingController {

    @Autowired
    IGroupCampingService iGroupCampingService;

    @GetMapping
    public List<GroupCamping> listAGroupCamping()
    {
        return iGroupCampingService.listGroupCamping();
    }

    @PostMapping("/addGroupCamping")
    public GroupCamping addGroupCamping (@RequestBody GroupCamping groupCamping)
    {
        return iGroupCampingService.addGroupCamping(groupCamping);
    }

    @PostMapping("/updateGroupCamping/{id}")
    public GroupCamping updateGroupCamping (@PathVariable("id") int id ,@RequestBody GroupCamping updategroupCamping)
    {
        return iGroupCampingService.updateGroupCamping(id ,updategroupCamping);
    }

    @DeleteMapping("/deleteGroupCamping/{id}")
    public void deleteGroupCamping (@PathVariable("id") int id)
    {
        iGroupCampingService.deleteGroupCamping(id);
    }

    @GetMapping("/retrievbyidGpCamping/{id}")
    public GroupCamping retrievbyidGpCamping (@PathVariable("id") int id)
    {
        return iGroupCampingService.retrievbyidGpCamping(id);
    }



    @GetMapping("/{groupId}/getGroupmembers")
    public List<User> getGroupmembers (@PathVariable int groupId)
    {
        return iGroupCampingService.getGroupmembers(groupId);
    }


    @PostMapping("/{groupId}/addUser/{userId}")
    public void addUserToGroup(@PathVariable int userId, @PathVariable int groupId)
    {
         iGroupCampingService.addUserToGroup(userId , groupId);
    }

    @PostMapping("/{groupId}/removeUser/{userId}")
    public void removeUserToGroup(@PathVariable int userId, @PathVariable int groupId)
    {
        iGroupCampingService.removeUserOfGroup(userId ,groupId);
    }


}
