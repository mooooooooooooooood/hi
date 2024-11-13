package DSA.tut6;

public class PolynomialTerm {
    private int coefficient;
    private int exponent;
    private PolynomialTerm next;

    public PolynomialTerm(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }

    public int getCoefficient() {
        return this.coefficient; //hằng số
    }
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
    public int getExponent() {
        return this.exponent; //số mũ
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    // Get the next term
    public PolynomialTerm getNext() {
        return next;
    }

    // Set the next term
    public void setNext(PolynomialTerm next) {
        this.next = next;
    }

    public void printTerm() {
        System.out.print(coefficient + "x^" + exponent);
    }
}

