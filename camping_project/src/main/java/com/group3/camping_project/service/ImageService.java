package com.group3.camping_project.service;

import com.group3.camping_project.Utils.ImageUtils;
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


    @Override
    public String saveImage(MultipartFile file) throws IOException {
        Image image= iImageRepo.save(Image.builder().imageData(ImageUtils.compressImage(file.getBytes())).build());
        if(image !=null){
            return "image uploaded successfully";}
        else {
            return null;
        }
    }

    @Override
    public byte[] getImage(int imageId) throws IOException {
        Image image=iImageRepo.findById(imageId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return   ImageUtils.decompressImage(image.getImageData());
    }


}