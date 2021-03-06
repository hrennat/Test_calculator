package com.it_academy.practice.junit_basics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {


    private Calculator calculator;

@Test
    public void testSum (){
    calculator = new Calculator(9, 5,6,7,-2,-8);
        int result = 17;
        Assert.assertEquals(result,calculator.calculate('+'),0.0001);

    }

    @Test
    void testSub (){
        calculator = new Calculator(9, 5, 8,0,145,-567,1456);
        int result = -1038;
        Assert.assertEquals(result,calculator.calculate('-'),0.0001);

    }

    @Test
     void testMult (){
        calculator= new Calculator(9, 5,8,-4,9,-6,-2);
         int result = -155520;
        Assert.assertEquals(result,calculator.calculate('*'),0.0001);

    }

    @Test
    void testDiv (){
        calculator = new Calculator(96,3,-2,-1,4 );
    int result = 4;
        Assert.assertEquals(result,calculator.calculate('/'),0.0001);

    }

    @Test
    void testOutOfRange() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/test/resources/test_OutOfRange.txt"));
        Assertions.assertThrows(NumberFormatException.class, () -> {
            calculator = new Calculator (Integer.parseInt(sc.next()),4,6);
        });
    }
    @Test
    void testInvalidData() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("./src/test/resources/test_InvalidData.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner finalSc = sc;
        Assertions.assertThrows(NumberFormatException.class, () -> {
            calculator = new Calculator (Integer.parseInt(finalSc.next()),6,7,9);
        });
    }

    @Test
    void testDivByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
           new Calculator(9,0,4).calculate('/');
        });
        assertEquals("/ by zero", exception.getMessage());
        System.out.println("Divide by Zero!");
    }


    @Test
    void testExp (){
        calculator = new Calculator(2, 3);
        int result = 8;
        Assert.assertEquals(result,calculator.calculate('^'),0.0001);

    }
    @Test
    void testSqrt (){
        calculator = new Calculator(64);
        int result = 8;
        Assert.assertEquals(result,calculator.calculate('???'),0.0001);

    }

    @Test
    void testInvalidOperation() {
        calculator = new Calculator(2, 7,9,-9,0,8);
            Assert.assertEquals(0,calculator.calculate('f'),0.0001);
        System.out.println("Nothing was thrown");
    }





}
