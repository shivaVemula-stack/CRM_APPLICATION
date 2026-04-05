package org.telusko.sampleApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
   @Test
    void testCalc(){
       Calc calc = new Calc();
       int actualResult = calc.multiply(4,5);
       int expectedResult = 20;
       assertEquals(actualResult,expectedResult);

    }
}
