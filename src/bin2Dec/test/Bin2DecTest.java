package bin2Dec.test;

import bin2Dec.src.Bin2Dec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Bin2DecTest {

    @Test
    public void convertTest1(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(30,bin2Dec.convertBin2Dec("11110"));
    }

    @Test
    public void convertTest2(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(10,bin2Dec.convertBin2Dec("1010"));
    }

    @Test
    public void convertTest3(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(127,bin2Dec.convertBin2Dec("1111111"));
    }

    @Test
    public void convertTest4(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(7,bin2Dec.convertBin2Dec("111"));
    }

    @Test
    public void convertTest5(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(991,bin2Dec.convertBin2Dec("1111011111"));
    }

    @Test
    public void convertTest6(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(7935,bin2Dec.convertBin2Dec("1111011111111"));
    }

    @Test
    public void convertTest7(){
        Bin2Dec bin2Dec = new Bin2Dec();
        assertEquals(62805,bin2Dec.convertBin2Dec("1111010101010101"));
    }
}
