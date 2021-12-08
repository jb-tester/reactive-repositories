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
        /*nonReactiveRepoService.testExistsOperator();
        implicitReactiveRepoService.findByNameUseReactiveTypes();
        rxJavaService.allByNameWithStr();
        rxJavaService.allWithReferences();
        rxJavaService.allByNameOrReference();
        rxJavaService.findUserWithAges();
        reactiveService.displayExistsByAgeResult();
        reactiveService.displayByNameAndAge();
        reactiveService.displayNameByAge();
        reactiveService.displayTop1AndFirst2ByAge();
        reactiveService.useProjection();
        reactiveService.displayByName();
        reactiveService.displayAgesQueries();
        
        reactiveRestaurantsService.showAllRestaurants();
        reactiveRestaurantsService.reactiveRestaurantsWithin();
        restaurantsService.showAllItalianRestaurants();
        restaurantsService.restaurantsWithinCircle();*/
        mixedRepoService.useMixedTypeQueries();
    }
}
