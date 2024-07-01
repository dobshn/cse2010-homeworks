## Homework #3

**Due: April 19 (Friday)**

In homework #3, you are required to complete the Polynomial ADT using a doubly-linked list.

```java
/*
 * © 2024 CSE2010 HW #2
 *
 * DO NOT MODIFY THIS CLASS!
 */

public interface Polynomial {
  /**
   * Returns the degree of the polynomial
   * @return degree
   */
  public int getDegree();

  /**
   * Returns the coefficient of the term with exponent "exp"
   * @param exp exponent of the term
   * @return the coefficient or zero if not exist
   */
  public double getCoefficient(final int exp);

  /**
   * Add this polynomial object with the polynomial "p" and returns the
   * resulting polynomial (c = a + b)
   * This object should "NOT" be changed as a result of this operation.
   * @param p polynomial to be added
   * @return a new polynomial
   */
  public Polynomial add(final Polynomial p);

  /**
   * Multiply this polynomial object with the polynomial "p" and returns
   * the resulting polynomial (c = a * b)
   * This object should "NOT" be changed as a result of this operation.
   * @param p polynomial to be multiplied
   * @return a new polynomial
   */
  Polynomial mult(final Polynomial p);

  /**
   * Insert a new term to this polynomial object.
   * Merge terms if a term with the same exponent already exists.
   * @param coeff coefficient of the term
   * @param expo exponent of the term
   */
  public void addTerm(final double coeff, final int expo);

  /**
   * Removes a term with exponent "expo".
   * @param expo exponent of the term to be removed
   * @throws NoSuchTermExistsException if no such term exists
   */
  public void removeTerm(final int expo);

  /**
   * Returns the result of the polynomial evaluation for a given input "x"
   * @param x the value to be evaluated by this polynomial
   * @return an evaluated value at point "x"
   */
  public double evaluate(final double x);

  /**
   * Returns the number of non-zero terms in this polynomial
   * @return the number of non-zero terms
   */
  public int termCount();
}

```

### Implementation Guidelines

- Implement the Polynomial ADT using a doubly-linked list.
- For `DLinkedList.java` and `DLinkedPolynomial.java`, you can freely modify the files to complete the code. You may add additional fields or private methods, if necessary. **However, public methods are not allowed to be added, and no method signatures should be changed**.

### What to submit?

- Your source codes archived in `.zip` or `.jar` format.
    - Subject: Homework#3, Section [A|B], 성명, 학번
    - Email to your TA (김정인, rkrkrk24@hanyang.ac.kr)
