package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.Restaurant;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * *
 * <p>Created by irina on 09.07.2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
public interface RestaurantReactiveRepo extends ReactiveCrudRepository<Restaurant, Integer> {
    
    // incorrect parameter type Point is suggested here:
    // causes CCE: class org.springframework.data.geo.Point cannot be cast to class org.springframework.data.geo.Shape
  //  Flux<Restaurant> findByLocationWithin(Point location); // incorrect!
   Flux<Restaurant> findByLocationWithin(Box location);   // correct, but IDEA shows the error here
}
