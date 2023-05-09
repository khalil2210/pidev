package com.group3.camping_project.service.file_service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.repository.IEquipmentRepo;
import com.group3.camping_project.utils.FileUtils;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.repository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class ImageService implements IImageService{

    @Autowired
    IImageRepo iImageRepo;
    @Autowired
    IEquipmentRepo iEquipmentRepo;


    @Override
    public Image saveImage(MultipartFile file) throws IOException {
       Image image= iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(file.getBytes())).build());

       if(image !=null){
        return image;}
    else {
        return null;
    }
    }

    @Override
    public byte[] getImage(int imageId) throws IOException {
        Image image=iImageRepo.findById(imageId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"The image doesn't exits"));
        return   FileUtils.decompressFile(image.getImageData());
    }
    @Override
    public Image saveImage1(MultipartFile image1) throws IOException {
        Image image= iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image1.getBytes())).build());

        return iImageRepo.save(image);
    }

    @Override
    public byte[] getImage1(int imageId) throws IOException {
        Image image = iImageRepo.findById(imageId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The image doesn't exist"));
        return FileUtils.decompressFile(image.getImageData());
    }
    @Override
    public Image saveImage2(MultipartFile image1,long id) throws IOException {
        Equipment equipment =iEquipmentRepo.findById(id).get();
        Image image= iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image1.getBytes())).build());
      // image.setEquipment(equipment);
        return iImageRepo.save(image);
    }


}
