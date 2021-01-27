package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import com.mytests.spring.jpa.reactiverepositories.repositories.UserReactiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/12/2020.
 * Project: reactive-repositories
 * *******************************
 */
@Service
public class ReactiveService {


    @Autowired
    private UserReactiveRepo userReactiveRepo;

    public void displayExistsByAgeResult(){
        System.out.println("=== reactive repo: existsByAge(18) ===");
        Mono<Boolean> rez = userReactiveRepo.existsByAge(18);
        System.out.println(rez.block());
    }
    public void displayByNameAndAge(){
        System.out.println("=== reactive repo: findByNameAndAge('name1',18) ===");
        Flux<User> users_flux = userReactiveRepo.findByNameAndAge("name1",Mono.just(18));
        for (User user : Objects.requireNonNull(users_flux.collectList().block())) {
            System.out.println(user.toString());
        }
    }
}
