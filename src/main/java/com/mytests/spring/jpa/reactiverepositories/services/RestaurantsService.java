package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.Restaurant;
import com.mytests.spring.jpa.reactiverepositories.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 09.07.2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
@Service
public class RestaurantsService {

    @Autowired
    private RestaurantRepo repo;
    public void showAllItalianRestaurants(){
        System.out.println("**********************************");
        System.out.println("all italian restaurants: ");

        for (Restaurant restaurant : repo.findByCuisineLike("Italian")) {
            System.out.println(restaurant.toString());
        }
        System.out.println("**********************************");
    }
    public void restaurantsWithinCircle(){
        System.out.println("**********************************");
        System.out.println("restaurants within the circle (non-reactive): ");
        Circle circle = new Circle(new Point(10,10), 20);

        for (Restaurant restaurant : repo.findByLocationWithin(circle)) {
            System.out.println(restaurant.toString());
        }
        System.out.println("**********************************");
    }
    public void restaurantsNear(){
        System.out.println("**********************************");
        System.out.println("restaurants near the point (non-reactive): ");
        Point point = new Point(10,10);

        for (Restaurant restaurant : repo.findByLocationNear(point, new Distance(10))) {
            System.out.println(restaurant.toString());
        }
        System.out.println("**********************************");
    }
}
