package com.paazl.cases.test2;

import com.paazl.cases.common.Constants;
import com.paazl.cases.common.developers.DeveloperFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /*
     * TODO
     * Implement a main method that is functionally identical to Test #1. In
     * this case, use a DeveloperFactory that is able to produce 3 types of
     * developers that implement a "print" method. The Factory should have a
     * create method that takes the user's score as an argument.
     */
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        AtomicInteger score = new AtomicInteger();
        System.out.println("Please answer on a several questions. Type only Y/y (in case positive answer) or N/n (in case negative). Others answers will be accepted as incorrect.");

        Constants.QUESTIONS.forEach((k, v)-> {
            System.out.println(k);
            if(v == Character.toUpperCase(reader.next().charAt(0))){
                score.getAndIncrement();
            }
        });
        DeveloperFactory.create(score.get()).print();
    }
}