package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.Restaurant;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

// MongoDB geospatial queries tests
public interface RestaurantReactiveRepo extends ReactiveCrudRepository<Restaurant, Integer> {
    
    // incorrect parameter type Point is suggested here:
    // causes CCE: class org.springframework.data.geo.Point cannot be cast to class org.springframework.data.geo.Shape
  //  Flux<Restaurant> findByLocationWithin(Point location); // incorrect!
   Flux<Restaurant> findByLocationWithin(Box location);   // correct, but IDEA shows the error here
}
