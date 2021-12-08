package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MixedUserRepo extends ReactiveCrudRepository<User, String>, ParentNonReactiveUserRepo {
    Flux<User> getAllByAgeAfter(Mono<Integer> age);
    //User findFirstByName(String name);  // reported as error here, but not in parent
}
