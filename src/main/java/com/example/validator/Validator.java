package com.example.validator;

public interface Validator {

    void validate(String inputString) throws Exception;

    boolean isArabian(String inputString);
}
