package com.humam.restaurants.controllers;

import com.humam.restaurants.models.Ad;
import com.humam.restaurants.models.Category;
import com.humam.restaurants.payload.request.AdRequest;
import com.humam.restaurants.payload.request.CategoryRequest;
import com.humam.restaurants.payload.response.MessageResponse;
import com.humam.restaurants.repository.AdRepository;
import com.humam.restaurants.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ad")
public class AdController {
  @Autowired
  AdRepository adRepository;

  @PostMapping("/create")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> create(@Valid @RequestBody AdRequest adRequest) {
    Ad ad = new Ad(adRequest.getTitle(),
            adRequest.getDescription(),adRequest.getImage());
    adRepository.save(ad);
    return ResponseEntity.ok(new MessageResponse("Ad Added successfully!"));
  }
}
