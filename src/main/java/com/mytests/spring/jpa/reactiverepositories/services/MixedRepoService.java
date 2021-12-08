package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import com.mytests.spring.jpa.reactiverepositories.repositories.MixedUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * *
 * <p>Created by irina on 12/7/2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
@Service
public class MixedRepoService {

    @Autowired
    private MixedUserRepo mixedUserRepo;

    public void useMixedTypeQueries() {
        System.out.println("=== Mixed Repository that extends non-reactive interface and ReactiveCrudRepository ===");
        System.out.println("= reactive query from child: =");
        for (User user : Objects.requireNonNull(mixedUserRepo.getAllByAgeAfter(Mono.just(50)).collectList().block())) {
            System.out.println(user.toString());
        }
        System.out.println("= non-reactive query from parent: =");
        //System.out.println(mixedUserRepo.findFirstByName("name3"));  // fails
        //System.out.println(mixedUserRepo.findFirstByName(Mono.just("name3")).block()); // works
    }

    ;
}
