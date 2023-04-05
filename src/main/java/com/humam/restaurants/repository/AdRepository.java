package com.humam.restaurants.repository;

import com.humam.restaurants.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
  Optional<Ad> findByTitle(String name);
}
