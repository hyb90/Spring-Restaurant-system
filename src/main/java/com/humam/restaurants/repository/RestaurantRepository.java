package com.humam.restaurants.repository;

import com.humam.restaurants.extras.CuisineType;
import com.humam.restaurants.models.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
  Optional<Restaurant> findByName(String name);

  @Query("SELECT r FROM Restaurant r "  +
          "WHERE ?1 IS NULL OR ?1 = '' OR r.name like CONCAT('%',?1,'%') OR" +
          " r.about like CONCAT('%',?1,'%') OR r.cuisineType like CONCAT('%',?1,'%') " )
  Page<Restaurant> searchByNameOrAboutOrCuisineType(String search, Pageable pageable);

  @Query("SELECT r FROM Restaurant r "  +
          "WHERE (?1 IS NULL OR ?1 = '' OR r.name like CONCAT('%',?1,'%')) AND" +
          " (?2 IS NULL OR r.longitude = ?2) AND (?3 IS NULL OR r.latitude = ?3) AND ( r.cuisineType = ?4 OR ?4 IS NULL ) " )
  Page<Restaurant> filterByNameAndAboutAndCuisineTypeAndLocation(String name, Double longitude,Double latitude, CuisineType cuisineType, Pageable pageable);
}
