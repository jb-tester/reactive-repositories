package com.mytests.spring.jpa.reactiverepositories.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: reactiveTest1
 * *******************************
 */
@Document("user")
public class User {

    @Id
    BigInteger id;
    @Field("name")
    String name;
    int age;
    //@DBRef
    List<String> references;

    

    public User(String name, int age, List<String> references) {
        this.name = name;
        this.age = age;
        this.references = references;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", references=" + references +
                ' ';
    }
}
