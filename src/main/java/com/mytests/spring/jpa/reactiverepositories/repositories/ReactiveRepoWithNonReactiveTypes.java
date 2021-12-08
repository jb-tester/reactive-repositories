package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;
import java.util.List;

interface ReactiveRepoWithNonReactiveTypes extends ReactiveCrudRepository<User, BigInteger> {
   List<User> findAllByName(String name); // error reported - ok
   User findByName(String name);           // error reported - ok
}