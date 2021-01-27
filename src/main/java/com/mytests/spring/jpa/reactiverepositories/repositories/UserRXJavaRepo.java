package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;

//import rx.Observable;
//import rx.Single;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/12/2020.
 * Project: reactive-repositories
 * *******************************
 */
public interface UserRXJavaRepo extends RxJava2CrudRepository<User, String> {

    Observable<User> findAllByNameContaining(String name);

    Observable<User> findAllByNameIn(Observable<String> name);

    Flowable<User> findByReferences(Flowable<String> references);

     User findFirstByAgeBetween(Single<Integer> min, int max);
}
