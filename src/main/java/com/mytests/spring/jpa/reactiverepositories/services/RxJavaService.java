package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.repositories.UserRXJavaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;


@Service
public class RxJavaService {


    @Autowired
    private UserRXJavaRepo userRXJavaRepo;

     public void allByNameWithStr() throws InterruptedException {
         CountDownLatch countDownLatch = new CountDownLatch(1);
        userRXJavaRepo.findAllByNameContaining("name")
                .doOnNext(System.out::println) //
                .doOnComplete(countDownLatch::countDown) //
                .doOnError(throwable -> countDownLatch.countDown()) //
                .subscribe();

         countDownLatch.await();
     }
}
