package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import com.mytests.spring.jpa.reactiverepositories.repositories.UserName;
import com.mytests.spring.jpa.reactiverepositories.repositories.UserReactiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
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
        displayFoundUsers(users_flux);
    }
    public void displayNameByAge(){
        System.out.println("=== reactive repo: findFirstNameByAgeGreaterThan(20) ===");
        Mono<String> rez = userReactiveRepo.findFirstNameByAgeGreaterThan(20);
        System.out.println(rez.block());
    }
    public void displayTop1AndFirst2ByAge(){
        System.out.println("=== reactive repo: findTop1ByAgeLessThan(60) ===");
        Mono<User> mrez = userReactiveRepo.findTop1ByAgeLessThan(Mono.just(60));
        System.out.println(mrez.block());
        System.out.println("=== reactive repo: findFirst2ByAgeLessThan(60) ===");
        Flux<User> rez = userReactiveRepo.findFirst2ByAgeLessThan(Mono.just(60));
        for (User user : Objects.requireNonNull(rez.collectList().block())) {
            System.out.println(user);
        }
    }
    public void useProjection(){

        System.out.println("=== reactive repo: use UserName projection");
        Flux<UserName> projections = userReactiveRepo.findByAgeIn(Flux.fromArray(new Integer[]{50, 60}));
        for (UserName userName : Objects.requireNonNull(projections.collectList().block())) {
            System.out.println(userName.getName());
        }
    }
    public void displayByName(){
        System.out.println("=== reactive repo: findByName('name1') ===");
        Flux<User> users_flux = userReactiveRepo.findByName("name1");
        displayFoundUsers(users_flux);
    }
    public void displayAgesQueries(){
        Mono<Integer> age = Mono.just(30);
        Mono<Integer> age2 = Mono.just(50);
        List<Integer> agesList = new ArrayList<>();
        agesList.add(18);
        agesList.add(25);
        Flux<Integer> ages = Flux.fromIterable(agesList);
       // Flux<User> users1 = userReactiveRepo.findByAgeIsNotIn(age);
        Flux<User> users1 = Flux.from(userReactiveRepo.findByAgeIsNotIn(ages));
        //Flux<User> users2 = userReactiveRepo.findByAgeBetween(age);
        Flux<User> users2 = userReactiveRepo.findByAgeBetween(age,age2);
        
        Flux<User> users4 = userReactiveRepo.findByAge(age);
        //Flux<User> users4 = userReactiveRepo.findByAge(ages);
        System.out.println("**********************************");
        System.out.println("users of age not in (param)");
        displayFoundUsers(users1);
        System.out.println("**********************************");
        System.out.println("users of age between (param)");
        displayFoundUsers(users2);
        System.out.println("**********************************");
        System.out.println("users of (param) age ");
        displayFoundUsers(users4);
        System.out.println("**********************************");
    }
    private void displayFoundUsers(Flux<User> users1) {
        for (User user : Objects.requireNonNull(users1.collectList().block())) {
            System.out.println(user.toString());
        }
    }
}
