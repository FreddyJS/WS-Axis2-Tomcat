package calculator;

public class CalculatorService implements Calculadora {

    @Override
    public int sumar(int s1, int s2) {
        return (s1 + s2);
    }

    @Override
    public int restar(int min, int sus) {
        return (min - sus);
    }

    @Override
    public int multiplicar(int m1, int m2) {
        return (m1*m2);
    }

    @Override
    public float dividir(int num, int den) {
        return (num/den);
    }

}
