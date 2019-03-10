package ZAD1;

import java.lang.ArithmeticException;

public class Calculator {

    public int add(int a, int b) throws ArithmeticException {
        /////////////////INT METHODS///////////////////
        if (a > 0 && b > 0 && a + b < 0) throw new ArithmeticException("BLAD - overflow");
        //else if (a < 0 && b < 0 && a + b > 0) throw new ArithmeticException("BLAD - underflow");
        return a + b;
    }

    public int diff(int a, int b) throws ArithmeticException {
        if (a > 0 && b < 0 && a - b < 0) throw new ArithmeticException("BLAD - overflow");
        else if (a < 0 && b > 0 && a - b > 0) throw new ArithmeticException("BLAD - underflow");
        return a - b;
    }

    public int mul(int a, int b) throws ArithmeticException {
        if (a > 0 && b > 0 && a * b < 0) throw new ArithmeticException("BLAD - overflow");
        else if (a != 0 && b != 0 && a * b == 0) throw new ArithmeticException("BLAD - underflow");
        return a * b;
    }

    public double div(int a, int b) throws ArithmeticException {
        //if (a > 0 && b > 0 && a / b < 0) throw new ArithmeticException("BLAD - overflow");
        if (a != 0 && b == 0) throw new ArithmeticException("BLAD - dzielenie przez zero");
        else if (a == 0 && b == 0) throw new ArithmeticException("BLAD - wystepuje symbol nieoznaczony");
        //else if (a > 0 && b > 0 && a/b == 0) throw new ArithmeticException("BLAD - underflow");
        return a / b;
    }

    /////////////////DOUBLE METHODS///////////////////
    public double add(double a, double b) throws ArithmeticException {
        if (Double.isInfinite(a + b)) throw new ArithmeticException("BLAD - overflow");
        //else if ( a!=0 && b!=0 && a+b==0) throw new ArithmeticException("BLAD - underflow");
        return a + b;
    }

    public double diff(double a, double b) throws ArithmeticException {
        if (Double.isInfinite(a - b)) throw new ArithmeticException("BLAD - overflow");
        //else if (a < 0 && b > 0 && a - b > 0) throw new ArithmeticException("BLAD - underflow");
        return a - b;
    }

    public double mul(double a, double b) throws ArithmeticException {
        if (Double.isInfinite(a * b) || (a > 2.0 && b > 2.0 && a * b < 2.0)) throw new ArithmeticException("BLAD - overflow");
        else if (a > 0 && b > 0 && a * b < 0) throw new ArithmeticException("BLAD - overflow");
        else if (a > 0 && b > 0 && a * b == 0) throw new ArithmeticException("BLAD - underflow");
        return a * b;
    }

    public double div(double a, double b) throws ArithmeticException {
        if (a == 0.0 && b == 0.0) throw new ArithmeticException("BLAD - wystepuje symbol nieoznaczony");
        else if (a != 0.0 && b == 0.0) throw new ArithmeticException("BLAD - dzielenie przez zero");
        //else if (a!=0 && b!=0 && Double.isInfinite(a / b)) throw new ArithmeticException("BLAD - overflow");
        else if (a > 0 && b > 0 && a/b == 0) throw new ArithmeticException("BLAD - underflow");

        return a / b;
    }

}
