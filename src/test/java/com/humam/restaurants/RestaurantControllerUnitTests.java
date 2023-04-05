package com.humam.restaurants;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import com.humam.restaurants.controllers.RestaurantController;
import com.humam.restaurants.extras.CuisineType;
import com.humam.restaurants.models.Category;

import com.humam.restaurants.payload.request.RestaurantRequest;
import com.humam.restaurants.repository.CategoryRepository;

import com.humam.restaurants.repository.RestaurantRepository;
import com.humam.restaurants.services.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)

public class RestaurantControllerUnitTests {
    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantRepository restaurantRepository;
    @Mock
    CategoryRepository categoryRepository;
    @Mock
    RestaurantService restaurantService;

    @Test
    public void testAddRestaurant()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(1L);
        when(categoryRepository.existsById(1L)).thenReturn(true);

        RestaurantRequest restaurantRequest = new RestaurantRequest("test", "test", category, CuisineType.AMERICAN,43.9999,45.9999);
        ResponseEntity<?> responseEntity = restaurantController.create(restaurantRequest);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }


}
