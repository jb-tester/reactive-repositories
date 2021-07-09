package com.mytests.spring.jpa.reactiverepositories.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

/**
 * *
 * <p>Created by irina on 09.07.2021.</p>
 * <p>Project: reactive-repositories</p>
 * *
 */
@Document("restaurant")
public class Restaurant {
    @Id
    BigInteger id;
    @Field("name")
    String name;
    String cuisine;
    Point location;


    public Restaurant(String name, String cuisine, Point location) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant: " +
                name + 
                ", cuisine= " + cuisine + 
                ' ';
    }
}
