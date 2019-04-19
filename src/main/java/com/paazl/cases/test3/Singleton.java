package com.paazl.cases.test3;

import com.paazl.cases.common.Constants;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class Singleton {
    private static Singleton ourInstance = new Singleton();

    private Singleton() {
    }

    static Singleton getInstance() {
        return ourInstance;
    }

    int passTest(){
        Scanner reader = new Scanner(System.in);
        AtomicInteger score = new AtomicInteger(0);

        System.out.println("Please answer on a several questions. Type only Y/y (in case positive) or N/n (in case negative) answer. Others answers will be accepted as incorrect.");
        Constants.QUESTIONS.forEach((k, v)-> {
            System.out.println(k);
            if(v == Character.toUpperCase(reader.next().charAt(0))){
                score.getAndIncrement();
            }
        });
        return score.get();
    }
}
