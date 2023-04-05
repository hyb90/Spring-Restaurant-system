package com.humam.restaurants.controllers;


import com.humam.restaurants.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/image")
public class ImageController {
  @Autowired
  private ImageService imageService;

  @PostMapping("/upload")
  @PreAuthorize("hasRole('EDITOR')")
  public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
    return new ResponseEntity<>(imageService.uploadImage(file),HttpStatus.OK);
  }
}
