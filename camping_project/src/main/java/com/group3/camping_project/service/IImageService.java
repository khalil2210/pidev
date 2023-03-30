package com.group3.camping_project.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {
    public String saveImage(MultipartFile image) throws IOException;

    public byte[] getImage(int imageId) throws IOException;
}
