package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.Restaurant;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;


public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {
    
    List<Restaurant> findByCuisineLike(String cuisine);

    // incorrect parameter type Point is suggested here:
    // causes CCE: class org.springframework.data.geo.Point cannot be cast to class org.springframework.data.geo.Shape
    //  List<Restaurant> findByLocationWithin(Point location); // incorrect!
    List<Restaurant> findByLocationWithin(Circle location);   // correct, but IDEA shows the error here
}
