package com.paazl.cases.test1;

import com.paazl.cases.common.Constants;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	/*
	 * TODO
	 * Implement the main method:
	 * * Show the user the questions from Constants.QUESTIONS on a console and collect the answers.
	 * * If the user scores 0-3 points, print "You are a junior Java developer".
	 * * If the user scores 4-7 points, print "You are a medior Java developer".
	 * * If the user scores 8-10 points, print "You are a senior Java developer".
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		AtomicInteger score = new AtomicInteger(0);
		System.out.println("Please answer on a several questions. Type only Y/y (in case positive) or N/n (in case negative) answer. Others answers will be accepted as incorrect.");

		Constants.QUESTIONS.forEach((k,v)-> {
			System.out.println(k);
			if(v == Character.toUpperCase(reader.next().charAt(0))){
				score.getAndIncrement();
			}
		});

		System.out.println(score.get() < 4 ? "You are a junior Java developer" : (score.get() < 8 ? "You are a medior Java developer" : "You are a senior Java developer"));
	}
}