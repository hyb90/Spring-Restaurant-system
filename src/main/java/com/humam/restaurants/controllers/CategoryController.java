package com.humam.restaurants.controllers;

import com.humam.restaurants.models.Category;
import com.humam.restaurants.models.User;
import com.humam.restaurants.payload.request.CategoryRequest;
import com.humam.restaurants.payload.response.MessageResponse;
import com.humam.restaurants.repository.CategoryRepository;
import com.humam.restaurants.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @PostMapping("/create")
  @PreAuthorize("hasRole('EDITOR')")
  public ResponseEntity<?>  create(@Valid @RequestBody CategoryRequest categoryRequest) {
    Category category = new Category(categoryRequest.getName(),
            categoryRequest.getFeaturedImage());
    categoryRepository.save(category);
    return ResponseEntity.ok(new MessageResponse("Category Added successfully!"));
  }

}
