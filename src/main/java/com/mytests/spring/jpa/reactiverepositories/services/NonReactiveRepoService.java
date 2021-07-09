package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import com.mytests.spring.jpa.reactiverepositories.repositories.UserImperativeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 09.07.2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
@Service
public class NonReactiveRepoService {
    
    @Autowired
    MongoOperations mongoOperations;
    @Autowired
    UserImperativeRepo repo;
    
    public void init(){
        List<String> ref3 = new ArrayList<>();
        ref3.add("reference41");
        ref3.add("reference42");
        ref3.add("reference43");
        User user1 = new User("name6", 50, null);
        User user2 = new User("name5", 60, null);
        User user3 = new User("name4", 30, ref3);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        repo.saveAll(users);
    }
    public void testExistsOperator(){
        List<User> users = repo.findByReferencesExists(false);
        System.out.println("**********************************");
        System.out.println("UserImperativeRepo.findByReferencesExists() test:");
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("**********************************");
    }

}
