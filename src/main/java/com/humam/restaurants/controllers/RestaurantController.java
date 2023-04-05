package com.humam.restaurants.controllers;

import com.humam.restaurants.extras.CuisineType;
import com.humam.restaurants.models.Restaurant;
import com.humam.restaurants.payload.request.RestaurantRequest;
import com.humam.restaurants.payload.response.MessageResponse;
import com.humam.restaurants.repository.AdRepository;
import com.humam.restaurants.repository.CategoryRepository;
import com.humam.restaurants.repository.RestaurantRepository;
import com.humam.restaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

  @Autowired
  RestaurantService restaurantService;

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  AdRepository adRepository;

  @PostMapping("/add")
  @PreAuthorize("hasRole('EDITOR')")
  public ResponseEntity<?> create(@Valid @RequestBody RestaurantRequest restaurantRequest) {
    if(!categoryRepository.existsById((restaurantRequest.getCategory().getId()))) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: selected category not exists!"));
    }
    restaurantService.Add(restaurantRequest);
    return ResponseEntity.ok(new MessageResponse("Restaurant Added successfully!"));
  }

  @GetMapping("/featured-categories")
  public ResponseEntity<?> getFeaturedCategories(Pageable pageable) {
    return new ResponseEntity<>(categoryRepository.findAll(pageable), HttpStatus.OK);
  }
  @GetMapping("/ads")
  public ResponseEntity<?> getAds(Pageable pageable) {
    return new ResponseEntity<>(adRepository.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping("/cuisine")
  public ResponseEntity<?> getCuisine(Pageable pageable) {
    List<CuisineType> result = Arrays.asList(CuisineType.values());
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/search")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<Page<Restaurant>> searchRestaurant(
          @RequestParam(name = "search",
                  required = false) String search,
          Pageable pageable
  ) {
    return new ResponseEntity<>(restaurantService.search(search,pageable), HttpStatus.OK);
  }
  @GetMapping("/filter")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<Page<Restaurant>> filterRestaurant(
          @RequestParam(name = "name",
                  required = false) String name,
          @RequestParam(name = "longitude",
                  required = false) Double longitude,
          @RequestParam(name = "latitude",
                  required = false) Double latitude,
          @RequestParam(name = "cuisineType",
                  required = false) CuisineType cuisineType,
          Pageable pageable
  ) {
    return new ResponseEntity<>(restaurantService.filter(name,longitude,latitude,cuisineType,pageable), HttpStatus.OK);
  }
}
