package com.rumahorbo.app;

import com.rumahorbo.app.structural.adapter.Gold;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int sumIteration = sc.nextInt();
        System.out.println(solve(sumIteration));
    }

    private static int solve(int sumIteration) {
        int total = 0;
        if (sumIteration <= 0) {
            return total;
        }
        return solveNumber(total, sumIteration - 1);
    }

    private static int solveNumber(int total, int iterationNumber) {
        int number = sc.nextInt();
        total += number;
        if (iterationNumber == 0) {
            return total;
        }
        iterationNumber--;
        return solveNumber(total, iterationNumber);
    }
}
