package com.mytests.spring.jpa.reactiverepositories.repositories;

import com.mytests.spring.jpa.reactiverepositories.data.User;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;

import java.util.List;

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


    Flowable<User> findByReferencesNotNull(); // Flowable<T> return type is reported as error

    Flowable<User> findByReferences(Flowable<String> references); // Flowable<T> parameter type is reported as error;
    // Single<List<T>> is suggested for collection-type fields

    Observable<User> findByNameOrReferences(Single<String> name, List<String> references);

     //User findFirstByAgeBetween(int min, int max); // 'User' type is reported as error - ok
     Maybe<User> findFirstByAgeBetween(int min, int max); // Maybe<T> type is reported as error
}
