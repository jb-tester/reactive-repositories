package com.mytests.spring.jpa.reactiverepositories.services;

import com.mytests.spring.jpa.reactiverepositories.repositories.UserRXJavaRepo;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


@Service
public class RxJavaService {


    @Autowired
    private UserRXJavaRepo userRXJavaRepo;

     public void allByNameWithStr() throws InterruptedException {
         System.out.println("=== rx repo: findAllByNameContaining('name') ===");
         CountDownLatch countDownLatch = new CountDownLatch(1);
        userRXJavaRepo.findAllByNameContaining("name")
                .doOnNext(System.out::println) //
                .doOnComplete(countDownLatch::countDown) //
                .doOnError(throwable -> countDownLatch.countDown()) //
                .subscribe();

         countDownLatch.await();
     }
    public void allWithReferences() throws InterruptedException {
        System.out.println("=== rx repo: findByReferences(): Flowable return type, Flowable parameter ===");
        CountDownLatch countDownLatch = new CountDownLatch(1);

        userRXJavaRepo.findByReferencesNotNull().doOnNext(user -> {
            userRXJavaRepo.findByReferences(Flowable.fromIterable(user.getReferences()))
                    .doOnNext(System.out::println) //
                    .doOnComplete(countDownLatch::countDown) //
                    .doOnError(throwable -> countDownLatch.countDown()) //
                    .subscribe();

        }).doOnComplete(countDownLatch::countDown).subscribe();

        countDownLatch.await(1000, TimeUnit.MILLISECONDS);

    }
    public void allByNameOrReference() throws InterruptedException {
        System.out.println("=== rx repo: findByNameOrReferences('name6'), refs) ===");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList<String> list = new ArrayList<>();
        list.add("reference51");
        list.add("reference52");
        list.add("reference53");
        //Single<List<String>> refs = Single.just(list);
        userRXJavaRepo.findByNameOrReferences(Single.just("name6"), list)
                .doOnNext(System.out::println) //
                .doOnComplete(countDownLatch::countDown) //
                .doOnError(throwable -> countDownLatch.countDown()) //
                .subscribe();

        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
    }

    public void findUserWithAges(){
        System.out.println("=== rx repo: findFirstByAgeBetween(30,60)");
        //System.out.println(userRXJavaRepo.findFirstByAgeBetween(40, 60)); // invalid query usage
        System.out.println(userRXJavaRepo.findFirstByAgeBetween(40, 50).blockingGet());
    }

}
