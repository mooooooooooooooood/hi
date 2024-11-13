package DSA.tut6;

public class Polynomial {
    private PolynomialTerm head;

    // Constructor
    public Polynomial() {
        this.head = null;
    }

    // Add a term to the polynomial
    public void addTerm(int coefficient, int exponent) {
        PolynomialTerm newTerm = new PolynomialTerm(coefficient, exponent);
        if (head == null) {
            head = newTerm;
        } else {
            PolynomialTerm current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTerm);
        }
    }

    // Display the polynomial
    public void printPolynomial() {
        PolynomialTerm current = head;
        while (current != null) {
            current.printTerm();
            if (current.getNext() != null) {
                System.out.print(" + ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    // Add two polynomials
    public Polynomial addPolynomials(Polynomial other) {
        Polynomial result = new Polynomial();
        PolynomialTerm current1 = this.head;
        PolynomialTerm current2 = other.head;

        while (current1 != null && current2 != null) {
            if (current1.getExponent() == current2.getExponent()) {
                result.addTerm(current1.getCoefficient() + current2.getCoefficient(), current1.getExponent());
                current1 = current1.getNext();
                current2 = current2.getNext();
            } else if (current1.getExponent() > current2.getExponent()) {
                result.addTerm(current1.getCoefficient(), current1.getExponent());
                current1 = current1.getNext();
            } else {
                result.addTerm(current2.getCoefficient(), current2.getExponent());
                current2 = current2.getNext();
            }
        }

        // Add remaining terms from the longer polynomial
        while (current1 != null) {
            result.addTerm(current1.getCoefficient(), current1.getExponent());
            current1 = current1.getNext();
        }

        while (current2 != null) {
            result.addTerm(current2.getCoefficient(), current2.getExponent());
            current2 = current2.getNext();
        }

        return result;
    }

    // Multiply two polynomials
    public Polynomial multiplyPolynomials(Polynomial other) {
        Polynomial result = new Polynomial();
        PolynomialTerm current1 = this.head;

        while (current1 != null) {
            PolynomialTerm current2 = other.head;
            while (current2 != null) {
                int newCoefficient = current1.getCoefficient() * current2.getCoefficient();
                int newExponent = current1.getExponent() + current2.getExponent();

                // Check if a term with the same exponent exists in the result polynomial
                PolynomialTerm existingTerm = result.findTermWithExponent(newExponent);

                if (existingTerm != null) {
                    // If the term already exists, add the coefficients
                    existingTerm.setCoefficient(existingTerm.getCoefficient() + newCoefficient);
                } else {
                    // If the term does not exist, add a new term to the result polynomial
                    result.addTerm(newCoefficient, newExponent);
                }

                current2 = current2.getNext();
            }
            current1 = current1.getNext();
        }

        return result;
    }

    // Find a term with a specific exponent in the polynomial
    private PolynomialTerm findTermWithExponent(int exponent) {
        PolynomialTerm current = this.head;

        while (current != null) {
            if (current.getExponent() == exponent) {
                return current;
            }
            current = current.getNext();
        }
        return null; // Term with the given exponent not found
    }
}
