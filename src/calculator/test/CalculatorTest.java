package calculator.test;

import calculator.src.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator;

    public CalculatorTest() {
        this.calculator = new Calculator();
    }

    @Test
    public void testSum(){
        assertEquals(4,this.calculator.getResult("2+2"));
        assertEquals(105,this.calculator.getResult("100+5"));
        assertEquals(170,this.calculator.getResult("120+50"));
    }

    @Test
    public void testSub(){
        assertEquals(0,this.calculator.getResult("2-2"));
        assertEquals(131,this.calculator.getResult("178-47"));
        assertEquals(-852,this.calculator.getResult("158-1010"));
    }

    @Test
    public void testPlus(){
        assertEquals(4,this.calculator.getResult("2*2"));
        assertEquals(243,this.calculator.getResult("27*9"));
        assertEquals(3588,this.calculator.getResult("39*92"));
    }

    @Test
    public void testDiv(){
        assertEquals(1,this.calculator.getResult("2/2"));
        assertEquals(3,this.calculator.getResult("27/9"));
        assertEquals(0.42391304347826086,this.calculator.getResult("39/92"));
    }

    @Test
    public void testPow(){
        assertEquals(16,this.calculator.getResult("2^4"));
        assertEquals(49,this.calculator.getResult("7^2"));
        assertEquals(125,this.calculator.getResult("5^3"));
    }


}
