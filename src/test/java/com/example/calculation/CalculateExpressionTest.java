package com.example.calculation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateExpressionTest {

    @Test
    public void testNumbersMoreThan10() {
        Calculate calculate = new CalculateExpression();
        String inputString1 = "11 + 1";
        String inputString2 = "1 + 11";
        String inputString3 = "XI + I";
        String inputString4 = "I + XI";

        Assertions.assertThrows(Exception.class, () -> calculate.calculate(inputString1));
        Assertions.assertThrows(Exception.class, () -> calculate.calculate(inputString2));
        Assertions.assertThrows(Exception.class, () -> calculate.calculate(inputString3));
        Assertions.assertThrows(Exception.class, () -> calculate.calculate(inputString4));
    }

    @Test
    public void testNumbersLessThan10() throws Exception{
        Calculate calculate = new CalculateExpression();
        String inputString1 = "1 + 1";
        String expectedString1 = "2";

        String inputString2 = "2 * 10";
        String expectedString2 = "20";

        String inputString3 = "X - I";
        String expectedString3 = "IX";

        String inputString4 = "VI / II";
        String expectedString4 = "III";

        String inputString5 = "2 - 10";
        String expectedString5 = "-8";

        Assertions.assertEquals(expectedString1,calculate.calculate(inputString1));
        Assertions.assertEquals(expectedString2,calculate.calculate(inputString2));
        Assertions.assertEquals(expectedString3,calculate.calculate(inputString3));
        Assertions.assertEquals(expectedString4,calculate.calculate(inputString4));
        Assertions.assertEquals(expectedString5,calculate.calculate(inputString5));
    }
    @Test
    public void testDoubleNumber(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "2.3 + 1";
        String inputString2 = "2 + 1.5";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));
        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString2));
    }

    @Test
    public void testDifferentNumbers(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "X + 1";
        String inputString2 = "2 * IV";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));
        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString2));
    }

    @Test
    public void testWrongRoman(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "W + II";
        String inputString2 = "CDDS * IV";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));
        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString2));
    }

    @Test
    public void testNegativeRoman(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "I - II";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));

    }

    @Test
    public void testDivideByZero(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "4 / 0";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));

    }

    @Test
    public void testWrongInput(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "1";
        String inputString2 = "X";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));
        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString2));

    }

    @Test
    public void testWrongOperator(){
        Calculate calculate = new CalculateExpression();
        String inputString1 = "1 = 3";
        String inputString2 = "X ? II";

        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString1));
        Assertions.assertThrows(Exception.class,() -> calculate.calculate(inputString2));

    }
}
