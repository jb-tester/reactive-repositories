package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.geo.Box;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/14/2020.
 * Project: reactive-repositories
 * *******************************
 */
public interface UserImperativeRepo extends CrudRepository<User, BigInteger> {
    // https://youtrack.jetbrains.com/issue/IDEA-172034:
    // exists keyword requires the boolean parameter, but IDEA shows it as an error - fixed
    List<User> findByReferencesExists(boolean exists);
    
   
}
