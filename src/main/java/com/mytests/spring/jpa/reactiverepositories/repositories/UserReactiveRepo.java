package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.Collection;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/12/2020.
 * Project: reactive-repositories
 * *******************************
 */
public interface UserReactiveRepo extends ReactiveCrudRepository<User, BigInteger> {

    Flux<User> findByAgeIsNotIn(Mono<Integer> age);
    Flux<User> findByNameAndAge(String name, Mono<Integer> age);
    Mono<Boolean> existsByAge(int age);
    Mono<String> findNameByAgeGreaterThan(int age);
    Mono<Integer> countByNameContaining(Mono<String> name);
     @Query("{ 'name' : ?0 }")
    Flux<User> findByName(String name);
    
    
}
