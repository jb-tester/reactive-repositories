package com.mytests.spring.jpa.reactiverepositories;

import com.mytests.spring.jpa.reactiverepositories.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveRepositoriesApplication implements CommandLineRunner {

    @Autowired
    private ImplicitReactiveRepoService implicitReactiveRepoService;
    @Autowired
    private RxJavaService rxJavaService;
    @Autowired
    private ReactiveService reactiveService;
    @Autowired
    private NonReactiveRepoService nonReactiveRepoService;
    @Autowired
    private ReactiveRestaurantsService reactiveRestaurantsService;
    @Autowired
    private RestaurantsService restaurantsService;
    @Autowired
    private MixedRepoService mixedRepoService;


    public static void main(String[] args) {
        SpringApplication.run(ReactiveRepositoriesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // nonReactiveRepoService.init();
        //  reactiveRestaurantsService.init();
        nonReactiveRepoService.testExistsOperator();
        Thread.sleep(1000);
        implicitReactiveRepoService.findByNameUseReactiveTypes();
        Thread.sleep(1000);
        mixedRepoService.useMixedTypeQueries();
        Thread.sleep(1000);
        rxJavaService.allByNameWithStr();
        Thread.sleep(1000);
        rxJavaService.allWithReferences();
        Thread.sleep(1000);
        rxJavaService.allByNameOrReference();
        Thread.sleep(1000);
        rxJavaService.findUserWithAges();
        Thread.sleep(1000);
        reactiveService.displayExistsByAgeResult();
        Thread.sleep(1000);
        reactiveService.displayByNameAndAge();
        Thread.sleep(1000);
        reactiveService.displayNameByAge();
        Thread.sleep(1000);
        reactiveService.displayTop1AndFirst2ByAge();
        Thread.sleep(1000);
        reactiveService.useProjection();
        Thread.sleep(1000);
        reactiveService.displayByName();
        Thread.sleep(1000);
        reactiveService.displayAgesQueries();
        Thread.sleep(1000);
        
        reactiveRestaurantsService.showAllRestaurants();
        Thread.sleep(1000);
        reactiveRestaurantsService.reactiveRestaurantsWithin();
        Thread.sleep(1000);
        restaurantsService.showAllItalianRestaurants();
        Thread.sleep(1000);
        restaurantsService.restaurantsWithinCircle();
        Thread.sleep(1000);
        restaurantsService.restaurantsNear();
    }
}
