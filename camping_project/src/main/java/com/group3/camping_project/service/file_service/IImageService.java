package com.group3.camping_project.service.file_service;

import com.group3.camping_project.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {

    public Image saveImage(MultipartFile image) throws IOException;

    public byte[] getImage(int imageId) throws IOException;
}
