package com.mytests.spring.jpa.reactiverepositories;

import com.mytests.spring.jpa.reactiverepositories.services.ImplicitReactiveRepoService;
import com.mytests.spring.jpa.reactiverepositories.services.RxJavaService;
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

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRepositoriesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         implicitReactiveRepoService.findByNameUseReactiveTypes();
         rxJavaService.allByNameWithStr();
    }
}
