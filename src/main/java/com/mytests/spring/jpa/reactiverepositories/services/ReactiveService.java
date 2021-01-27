package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.repositories.UserReactiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
