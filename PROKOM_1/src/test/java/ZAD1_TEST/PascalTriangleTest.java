package ZAD1_TEST;

import ZAD1.PascalTriangle;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;


public class PascalTriangleTest {
   @Test
    public void computeTest0() {
        PascalTriangle pt = new PascalTriangle();
        IllegalArgumentException thrown= assertThrows(IllegalArgumentException.class,
                ()->pt.compute(0));

        Assert.assertTrue(thrown.getMessage().contains("n musi byc wieksze od 0"));
    }
    @Test
    public void computeTest1(){
        PascalTriangle pt = new PascalTriangle();
        pt.compute(1);
        int[][] triangle=pt.getTriangle();
        Assert.assertEquals(1,triangle[0][0]);
    }
    @Test
    public void computeTest4(){
        PascalTriangle pt = new PascalTriangle();
        pt.compute(4);
        int[][] triangle=pt.getTriangle();
        Assert.assertEquals(1,triangle[0][0]);
        Assert.assertEquals(1,triangle[1][0]);
        Assert.assertEquals(1,triangle[1][1]);
        Assert.assertEquals(1,triangle[2][0]);
        Assert.assertEquals(2,triangle[2][1]);
        Assert.assertEquals(1,triangle[2][2]);
        Assert.assertEquals(1,triangle[3][0]);
        Assert.assertEquals(3,triangle[3][1]);
        Assert.assertEquals(3,triangle[3][2]);
        Assert.assertEquals(1,triangle[3][3]);
    }
    @Test
    public void computeTest3(){
        PascalTriangle pt = new PascalTriangle();
        IllegalArgumentException thrown=assertThrows(IllegalArgumentException.class,
                ()->pt.compute(-3));
        Assert.assertTrue(thrown.getMessage().contains("n musi byc wieksze od 0"));
    }
}
