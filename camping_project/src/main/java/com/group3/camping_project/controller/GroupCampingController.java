package com.group3.camping_project.controller;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.group_camping.IGroupCampingService;
import com.group3.camping_project.entities.GroupCamping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/GroupCamping")
public class GroupCampingController {

    @Autowired
    IGroupCampingService iGroupCampingService;

    @GetMapping("/GroupCampingS")
    public List<GroupCamping> listGroupCamping()
    {
        return iGroupCampingService.listGroupCamping();
    }

    @PostMapping("/addGroupCamping")
    public GroupCamping addGroupCamping (@Valid @RequestPart GroupCamping groupCamping, @RequestParam MultipartFile file) throws IOException {
        return iGroupCampingService.addGroupCamping(groupCamping,file);
    }

    @PutMapping(value = "/updateGroupCamping")
    public GroupCamping updateGroupCamping (@RequestParam MultipartFile file,@RequestPart GroupCamping updategroupCamping)throws IOException
    {
        return iGroupCampingService.updateGroupCamping(file ,updategroupCamping);
    }
    @PutMapping("/updateGroupCamping1")
    public GroupCamping updateGroupCamping1 (@RequestBody GroupCamping updategroupCamping)
    {
        return iGroupCampingService.updateGroupCamping1(updategroupCamping);
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



    @GetMapping("/retrievByDestination/{destination}")
    public List<GroupCamping> retrievByDestinationGpCamping (@PathVariable("destination") String destination)
    {
        return iGroupCampingService.retrievByDestinationGpCamping(destination);
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
