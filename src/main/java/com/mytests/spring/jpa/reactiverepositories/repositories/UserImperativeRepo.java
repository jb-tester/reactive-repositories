package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/14/2020.
 * Project: reactive-repositories
 * *******************************
 */
public interface UserImperativeRepo extends CrudRepository<User, BigInteger> {
}
