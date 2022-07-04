package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/12/2020.
 * Project: reactive-repositories
 * *******************************
 */
public interface UserImplicitReactRepo extends CrudRepository<User, BigInteger> {
    Flux<User> findAllByName(Mono<String> name); // https://youtrack.jetbrains.com/issue/IDEA-232843 - fixed

}
