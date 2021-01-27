package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import com.mytests.spring.jpa.reactiverepositories.repositories.UserImplicitReactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/12/2020.
 * Project: reactive-repositories
 * *******************************
 */
@Service
public class ImplicitReactiveRepoService {
    @Autowired
    private ReactiveMongoOperations operations;

    @Autowired
    private UserImplicitReactRepo userImplicitReactRepo;

    public void findByNameUseReactiveTypes(){

        System.out.println("=== implicit reactive repo: findAllByName('name3') ===");
        Mono<String> name = Mono.just("name3");
        List<User> users = userImplicitReactRepo.findAllByName(name).collectList().block();
        System.out.println(users.get(0).toString());
    }


    /*public void setUp(){
        List<String> ref1 = new ArrayList<>();
        ref1.add("reference11");
        ref1.add("reference12");
        ref1.add("reference13");
        List<String> ref2 = new ArrayList<>();
        ref2.add("reference21");
        ref2.add("reference22");
        ref2.add("reference23");
        List<String> ref3 = new ArrayList<>();
        ref3.add("reference31");
        ref3.add("reference32");
        ref3.add("reference33");
        User user1 = new User("name1", 18, ref1);
        User user2 = new User("name2", 21, ref2);
        User user3 = new User("name3", 12, ref3);

        operations.collectionExists(User.class) //
                .flatMap(exists -> exists ? operations.dropCollection(User.class) : Mono.just(exists)) //
                .flatMap(o -> operations.createCollection(User.class, new CollectionOptions(1024 * 1024, 100, true))) //
                .then() //
                .block();
        userRepo
                .save(Flux.just(user1, user2, user3)) //
                .then() //
                .block();


    }*/
}
