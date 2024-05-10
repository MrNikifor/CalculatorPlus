package com.example.calculation;

import com.example.convertor.ConvertIntegerToRoman;
import com.example.convertor.ConvertRomanToInteger;
import com.example.validator.ValidateInputString;
import com.example.validator.Validator;

public class CalculateExpression implements Calculate {
    private final Validator VALIDATOR = new ValidateInputString();

    @Override
    public String calculate(String inputString) throws Exception {
        VALIDATOR.validate(inputString);
        String[] parts = inputString.split(" ");
        if (VALIDATOR.isArabian(inputString)) {
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[2]);
            String operator = parts[1];
            return solveExpression(a, b, operator);
        }
        int a = ConvertRomanToInteger.convert(parts[0]);
        int b = ConvertRomanToInteger.convert(parts[2]);
        String operator = parts[1];
        if (operator.equals("-") && a < b) {
            throw new Exception();
        }
        String result = solveExpression(a, b, operator);
        return ConvertIntegerToRoman.convert(Integer.parseInt(result));
    }

    private String solveExpression(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+" -> {
                return String.valueOf(a + b);
            }
            case "-" -> {
                return String.valueOf(a - b);
            }
            case "*" -> {
                return String.valueOf(a * b);
            }
            case "/" -> {
                if (b == 0) {
                    throw new Exception();
                }
                return String.valueOf(a / b);
            }
            default -> throw new Exception();
        }
    }
}
