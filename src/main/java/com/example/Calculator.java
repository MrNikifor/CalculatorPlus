package com.example;

import com.example.calculation.Calculate;
import com.example.calculation.CalculateExpression;

import java.util.Scanner;

public class Calculator {
    private static final Calculate CALCULATE = new CalculateExpression();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputString = scanner.nextLine();
            System.out.println(CALCULATE.calculate(inputString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}