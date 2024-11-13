package DSA.tut6;

public class PolynomialApp {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.addTerm(2, 3);
        p1.addTerm(5, 2);
        p1.addTerm(1, 0);

        Polynomial p2 = new Polynomial();
        p2.addTerm(3, 2);
        p2.addTerm(4, 1);
        p2.addTerm(2, 0);

        System.out.println("Polynomial 1:");
        p1.printPolynomial();

        System.out.println("Polynomial 2:");
        p2.printPolynomial();

        Polynomial sum = p1.addPolynomials(p2);
        System.out.println("Sum of Polynomials:");
        sum.printPolynomial();

        Polynomial product = p1.multiplyPolynomials(p2);
        System.out.println("Product of Polynomials:");
        product.printPolynomial();
    }
}
