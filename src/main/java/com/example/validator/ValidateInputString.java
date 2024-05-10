package com.example.validator;

import com.example.convertor.ConvertRomanToInteger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInputString implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void validate(String inputString) throws Exception {
        boolean valid = validateSingleOperator(inputString) && validateSigns(inputString);

        if (!valid) {
            throw new Exception();
        }
    }


    @Override
    public boolean isArabian(String inputString) {
        if (!validateInput(inputString)) {
            return false;
        }
        String[] parts = inputString.split(" ");

        try {
            Integer.parseInt(parts[0]);
            Integer.parseInt(parts[2]);
            return Integer.parseInt(parts[0]) <= 10 && Integer.parseInt(parts[2]) <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isRoman(String inputString) {
        pattern = Pattern.compile("^([IVXLCDM]+)\\s*([/+*-])\\s*([IVXLCDM]+)$");
        matcher = pattern.matcher(inputString);
        if (!matcher.find()) {
            return false;
        }

        String[] parts = inputString.split(" ");
        int a = ConvertRomanToInteger.convert(parts[0]);
        int b = ConvertRomanToInteger.convert(parts[2]);
        return a <= 10 && b <= 10;
    }

    private boolean validateSigns(String inputString) {
        return isRoman(inputString) || isArabian(inputString);
    }


    private boolean validateSingleOperator(String inputString) {
        pattern = Pattern.compile("[/+*-]");
        matcher = pattern.matcher(inputString);
        return matcher.find();
    }

    private boolean validateInput(String inputString) {
        String[] parts = inputString.split(" ");
        return parts.length == 3;
    }
}
