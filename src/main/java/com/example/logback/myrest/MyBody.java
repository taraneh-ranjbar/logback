package com.example.logback.myrest;

import java.io.Serializable;

/**
 * Created by taraneh on 7/17/2020.
 */
public class MyBody implements Serializable {
    private String name;
    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyBody{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
