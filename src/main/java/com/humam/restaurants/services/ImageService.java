package com.humam.restaurants.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Optional;

import com.humam.restaurants.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.humam.restaurants.models.Image;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepo;

    @Value("${humam.app.imageFolder}")
    private String PATH;

    public Image uploadImage(MultipartFile file) throws IOException {
        String dateString=String.valueOf(new Date().getTime());
        String fullPath = PATH+dateString+file.getOriginalFilename();
        Image pImage = new Image();
        pImage.setTitle(dateString+file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImagePath(fullPath);

        file.transferTo(new File(fullPath));
        return imageRepo.save(pImage);
    }
}
