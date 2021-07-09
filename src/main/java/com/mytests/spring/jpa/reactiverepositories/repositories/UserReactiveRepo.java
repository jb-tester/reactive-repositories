package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/12/2020.
 * Project: reactive-repositories
 * *******************************
 */
public interface UserReactiveRepo extends ReactiveCrudRepository<User, BigInteger> {

   //Flux<User> findByAgeIsNotIn(Mono<Integer> age);  // incorrect, but no errors
    Flux<User> findByAgeIsNotIn(Flux<Integer> age);
    Flux<User> findByAgeBetween(Mono<Integer> age, Mono<Integer> age2);  //  ok
   //Flux<User> findByAgeBetween(Flux<Integer> age); // error shown: expected int, int   - ok
  
   // Flux<User> findByAge(Flux<Integer> age);  // incorrect, but no errors are shown
    Flux<User> findByAge(Mono<Integer> age);   // ok
    
    Flux<User> findByNameMatchesRegex(String name);  
    
    Flux<User> findByNameAndAge(String name, Mono<Integer> age);
    Mono<Boolean> existsByAge(int age);     // error is shown  https://youtrack.jetbrains.com/issue/IDEA-260454
    Flux<String> findNamesByAgeLessThan(Mono<Integer> age); // error is shown
 
   //Mono<String> findNameByAgeGreaterThan(int age);   // no error is shown but should!
    Mono<String> findFirstNameByAgeGreaterThan(int age);
    Mono<Integer> countByNameContaining(Mono<String> name);
    
    
     @Query("{ 'name' : ?0 }")
    Flux<User> findByName(String name);
    
    
}
