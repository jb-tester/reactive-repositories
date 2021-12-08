package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import reactor.core.publisher.Mono;

/**
 * *
 * <p>Created by irina on 12/7/2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
interface ParentNonReactiveUserRepo {
   User findFirstByName(String name); // invalid query
   //  Mono<User> findFirstByName(Mono<String> name); // correct variant
}
