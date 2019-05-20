package ZAD1_TEST;

import ZAD1.Calculator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Rule
    public ExpectedException wyjatek=ExpectedException.none();

    Calculator math=new Calculator();
    ////////////////INTEGER ADD TEST/////////////////
    @Test
    public void intAddTest1(){
        Assert.assertEquals(math.add(123,234),357);
    }
    @Test
    public void intAddTest2(){
        Assert.assertEquals(math.add(10, -20), -10);
    }
    @Test
    public void intAddTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        Assert.assertEquals(math.add(Integer.MAX_VALUE, Integer.MAX_VALUE), 2 * Integer.MAX_VALUE);
    }
    /*@Test
    public void intAddTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        assertEquals(math.add(Integer.MIN_VALUE, -10000), 2 );
    }*/
    ////////////////INTEGER DIFF TEST/////////////////
    @Test
    public void intDiffTest1(){
        Assert.assertEquals(5, math.diff(10, 5));
    }
    @Test
    public void intDiffTest2(){
        Assert.assertEquals(15, math.diff(10, -5));
    }
    @Test
    public void intDiffTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        Assert.assertEquals(0, math.diff(Integer.MAX_VALUE, -Integer.MAX_VALUE));
    }
    @Test
    public void intDiffTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        Assert.assertEquals(0, math.diff(Integer.MIN_VALUE, 10000));
    }

    ////////////////INTEGER MULL TEST/////////////////
    @Test
    public void intMulTest1(){
        Assert.assertEquals(20, math.mul(10, 2));
    }

    @Test
    public void intMulTest2(){
        Assert.assertEquals(math.mul(-5, 3), -15);
    }

    @Test
    public void intMulTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        Assert.assertEquals(math.mul(Integer.MAX_VALUE, 2), 1);
    }
    @Test
    public void intMulTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        Assert.assertEquals(math.mul(Integer.MIN_VALUE, Integer.MIN_VALUE), 1);
    }
    ////////////////"INTEGER" DIV TEST/////////////////
    @Test
    public void doubleDivTest1(){
        Assert.assertEquals(50, math.div(100, 2), 0.0);
    }
    @Test
    public void doubleDivTest2(){
        Assert.assertEquals(math.div(10, -5), -2, 0.0);
    }
    @Test
    public void doubleDivTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - dzielenie przez zero");
        Assert.assertEquals(0, math.div(10, 0), 0.0);
    }
    @Test
    public void doubleDivTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - wystepuje symbol nieoznaczony");
        Assert.assertEquals(0, math.div(0, 0));
    }/*
    @Test
    public void doubleDivTest5(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        Assert.assertEquals(1, math.div(Integer.MIN_VALUE,(-1)*Integer.MAX_VALUE*Integer.MAX_VALUE*Integer.MAX_VALUE), 0.0);
    }*/
    ////////////////DOUBLE ADD TEST/////////////////
    @Test
    public void doubleAddTest1(){
        Assert.assertTrue(math.add(12.56,23.44)==36);
    }
    @Test
    public void doubleAddTest2(){
        Assert.assertEquals(0.1, math.add(0.5, -0.4),0.01);
    }
    @Test
    public void doubleAddTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        Assert.assertTrue(math.add(Double.MAX_VALUE, Double.MAX_VALUE)== 2 * Double.MAX_VALUE);
    }/*
    @Test
    public void doubleAddTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        assertTrue(math.add((0.00000005)*Double.MIN_VALUE, -(0.000000000000005)*Double.MIN_VALUE)==0);
    }*/
    ////////////////DOUBLE DIFF TEST/////////////////
    @Test
    public void doubleDiffTest1(){
        Assert.assertTrue( math.diff(10.5, 5.25)==5.25);
    }
    @Test
    public void doubleDiffTest2(){
        Assert.assertTrue( math.diff(10.75, -5.1)==15.85);
    }
    @Test
    public void doubleDiffTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        Assert.assertEquals(0, math.diff(Double.MAX_VALUE, -Double.MAX_VALUE));
    }/*
    @Test
    public void doubleDiffTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        Assert.assertTrue(math.diff(Double.MIN_VALUE, 3*Double.MIN_VALUE)==0);
    }*/
    ////////////////DOUBLE MULL TEST/////////////////
    @Test
    public void doubleMulTest1(){
        Assert.assertEquals(26.25, math.mul(10.5, 2.5), 0.1);
    }

    @Test
    public void doubleMulTest2(){
        Assert.assertEquals(-16.213,math.mul(-5.23, 3.1), 0.01);
    }

    @Test
    public void doubleMulTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        assertEquals(1, math.mul(Double.MAX_VALUE, 2.5), 0.0);
    }
    @Test
    public void doubleMulTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        assertEquals(1, math.mul(Double.MIN_VALUE, 0.5), 0.0);
    }
    ////////////////INTEGER DIV TEST/////////////////
    @Test
    public void double2DivTest1(){
        Assert.assertEquals(5.25, math.div(10.5, 2), 0.0);
    }
    @Test
    public void double2DivTest2(){
        Assert.assertEquals( -2.02, math.div(10.1, -5.0), 0.0);
    }
    @Test
    public void double2DivTest3(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - dzielenie przez zero");
        Assert.assertTrue(math.div(10.5, 0.0)==1);
    }
    @Test
    public void double2DivTest4(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - wystepuje symbol nieoznaczony");
        Assert.assertTrue(math.div(0.0, 0.0)==0.0);
    }
    @Test
    public void double2DivTest5(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - underflow");
        Assert.assertTrue(math.div(Double.MIN_VALUE, Double.MAX_VALUE)==0.0);
    }
    /*
    @Test
    public void double2DivTest6(){
        wyjatek.expect(ArithmeticException.class);
        wyjatek.expectMessage("BLAD - overflow");
        Assert.assertTrue(math.div(Double.MIN_VALUE, Double.MIN_VALUE*Double.MIN_VALUE*Double.MIN_VALUE)==0.0);
    }*/
}
