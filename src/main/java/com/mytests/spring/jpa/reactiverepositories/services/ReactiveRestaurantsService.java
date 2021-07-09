package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.Restaurant;
import com.mytests.spring.jpa.reactiverepositories.data.User;
import com.mytests.spring.jpa.reactiverepositories.repositories.RestaurantReactiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * *
 * <p>Created by irina on 09.07.2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
@Service
public class ReactiveRestaurantsService {
    @Autowired
    private ReactiveMongoOperations operations;
    @Autowired
    private RestaurantReactiveRepo repo;

    public void init(){
        System.out.println("******** ReactiveRestaurantsService initialization ****");
        Point p0 = new Point(0,0);
        Point p100 = new Point(100,100);
        Point p20 = new Point(20,20);
        Point p30 = new Point(30,30);
        Point p40 = new Point(40,40);
        Point p50 = new Point(50,50);
        Restaurant r0 = new Restaurant("tokio", "Japanese", p0);
        Restaurant r1 = new Restaurant("dnepr", "Ukrainian", p100);
        Restaurant r2 = new Restaurant("vltava", "Czech", p20);
        Restaurant r3 = new Restaurant("moskva", "Russian", p30);
        Restaurant r4 = new Restaurant("tibr", "Italian", p40);
        Restaurant r5 = new Restaurant("hudson", "Italian", p50);


        operations.collectionExists(Restaurant.class) //
                .flatMap(exists -> exists ? operations.dropCollection(Restaurant.class) : Mono.just(exists)) //
                .flatMap(o -> operations.createCollection(Restaurant.class, new CollectionOptions((long) (1024 * 1024), 100L, true))) 
                .then() 
                .block();
        repo.saveAll(Flux.just(r0,r1,r2,r3,r4,r5)) 
                .then() //
                .block();

    }
    
    public void showAllRestaurants(){
        System.out.println("**********************************");
        System.out.println("all restaurants: ");
        Flux<Restaurant> restaurantFlux = repo.findAll();
        displayFoundRestaurants(restaurantFlux);
        System.out.println("**********************************");
    }
    public void reactiveRestaurantsWithin(){
        System.out.println("**********************************");
        System.out.println("restaurants within the box (reactive): ");
        Box box = new Box(new Point(0,0), new Point(50,50));
        // Flux<Restaurant> restaurantFlux = repo.findByLocationWithin(new Point(20,20));
        Flux<Restaurant> restaurantFlux = repo.findByLocationWithin(box);
        displayFoundRestaurants(restaurantFlux);
        System.out.println("**********************************");
    }
    private void displayFoundRestaurants(Flux<Restaurant> r) {
        for (Restaurant restaurant : Objects.requireNonNull(r.collectList().block())) {
            System.out.println(restaurant.toString());
        }
    }
}
