package com.humam.restaurants.services;

import com.humam.restaurants.extras.CuisineType;
import com.humam.restaurants.models.Restaurant;
import com.humam.restaurants.payload.request.RestaurantRequest;
import com.humam.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    public Restaurant Add(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant(restaurantRequest.getName(),
                restaurantRequest.getCuisineType(),restaurantRequest.getAbout(),restaurantRequest.getCategory(),restaurantRequest.getLongitude(),restaurantRequest.getLatitude());
        return restaurantRepository.save(restaurant);
    }
    public Page<Restaurant> search(String search,Pageable pageable) {
        if(search!=null)search=search.trim();
        return restaurantRepository.searchByNameOrAboutOrCuisineType(search,pageable);
    }
    public Page<Restaurant>  filter(String name, Double longitude, Double latitude, CuisineType cuisineType, Pageable pageable) {
        if(name!=null)name=name.trim();
        if(longitude==null)latitude=null;
        if(latitude==null)longitude=null;
        return restaurantRepository.filterByNameAndAboutAndCuisineTypeAndLocation(name,longitude,latitude,cuisineType,pageable);
    }
}
