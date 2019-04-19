package com.paazl.cases.test3;

import com.paazl.cases.common.Constants;
import com.paazl.cases.common.developers.DeveloperFactory;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /*
     * TODO
     * Implement a main method that is functionally identical to Test #2. In
     * this case, use a Singleton that poses the questions and gathers the answers.
     */
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        DeveloperFactory.create(singleton.passTest()).print();
    }
}