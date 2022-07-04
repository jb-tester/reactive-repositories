package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.reactivestreams.Publisher;
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

    // use Publisher as return type and parameters type
    Publisher<User> findByAgeIsNotIn(Publisher<Integer> age);

    Flux<User> findByAgeBetween(Mono<Integer> age, Mono<Integer> age2);  //  ok
    //Flux<User> findByAgeBetween(Flux<Integer> age); // error shown: expected int, int   - ok

    //Flux<User> findByAge(Flux<Integer> age);  // incorrect, but no errors are shown

    Flux<User> findByAge(Mono<Integer> age);   // ok

    Flux<User> findByNameMatchesRegex(String name);

    Flux<User> findByNameAndAge(String name, Mono<Integer> age);

    Mono<Boolean> existsByAge(int age);     // error is shown  https://youtrack.jetbrains.com/issue/IDEA-260454 - fixed

    Flux<User> findFirst2ByAgeLessThan(Mono<Integer> age); // first<number>
    Mono<User> findTop1ByAgeLessThan(Mono<Integer> age);   // top<number>
    Flux<UserName> findByAgeIn(Flux<Integer> age); // test projection and correct parameter type suggesting for 'in'
    Mono<Integer> countByNameContaining(Mono<String> name);
    Mono<String> findFirstNameByAgeGreaterThan(int age);


    //Mono<String> findNameByAgeGreaterThan(int age);   // no error is shown but should!

    @Query("{ 'name' : ?0 }")
    Flux<User> findByName(String name);


}
