## Homework #2

**Due: April 11 (Thursday)**

In homework #2, you have `SparseMatrix.java` to complete.

### Problem
Complete `SparseMatrix.java`.

```java
/*
 * DO NOT MODIFY THIS CLASS!
 */

/**
 * Represents an entry in a sparse matrix.
 * An entry consists of a row index, a column index, and a value.
 */
public class Entry {
    /**
     * The row index of this entry.
     */
    private int row;
    /**
     * The column index of this entry.
     */
    private int col;

    /**
     * The value of this entry.
     */
    private double value;

    /**
     * Constructs an Entry object with the given row, column, and value.
     *
     * @param row   The row index of this entry.
     * @param col   The column index of this entry.
     * @param value The value of this entry.
     */
    public Entry(int row, int col, double value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    /**
     * Constructs an Entry object with the same row, column, and value as the given Entry object.
     *
     * @param other The Entry object to copy.
     */
    public Entry(Entry other) {
        this.row = other.row;
        this.col = other.col;
        this.value = other.value;
    }

    /**
     * Compares this Entry object with the specified object for equality.
     *
     * @param o The object to compare.
     * @return true if the specified object is equal to this Entry object; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry entry)) return false;
        return row == entry.row &&
                col == entry.col &&
                Double.compare(entry.value, value) == 0;
    }

    /**
     * Returns a row index of this entry.
     *
     * @return The row index of this entry.
     */
    public int getRow() {
        return row;
    }

    /**
     * Set the row index of this entry.
     *
     * @param row The row index to set.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Returns a column index of this entry.
     *
     * @return The column index of this entry.
     */
    public int getCol() {
        return col;
    }

    /**
     * Set the column index of this entry.
     *
     * @param col The column index to set.
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Returns a value of this entry.
     *
     * @return The value of this entry.
     */
    public double getValue() {
        return value;
    }

    /**
     * Set the value of this entry.
     *
     * @param value The value to set.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns a string representation of this entry.
     *
     * @return A string representation of this entry.
     */
    @Override
    public String toString() {
        return "(" + row + ", " + col + ", " + value + ")";
    }
}
```

```java
/**
 * Represent an array implementation of a sparse matrix.
 * In the context of this assignment, a sparse matrix is represented as an array of Entry objects.
 */
public class ArraySparseMatrix implements SparseMatrix {

    /**
     * The array of Entry objects.
     */
    private Entry[] elements = new Entry[0];

    /**
     * Constructs an ArraySparseMatrix object with the given capacity.
     *
     * @param capacity The capacity of the array.
     */
    public ArraySparseMatrix(int capacity) {
        elements = new Entry[capacity];

        /*
         * your code goes here if necessary
         */
    }

    /**
     * Create a SparseMatrix object from a two-dimensional array.
     * This routine simulates reading from files using two-dimensional matrix.
     *
     * @param aMatrix The two-dimensional array to be converted to a SparseMatrix object.
     * @return a SparseMatrix object created from the given two-dimensional array.
     */
    public static SparseMatrix from(double[][] aMatrix) {

        /*
         * your code goes here
         */

        return null;
    }

    /**
     * Transpose the matrix.
     *
     * @ return a new SparseMatrix object that is the transpose of this matrix
     */
    @Override
    public SparseMatrix transpose() {

        /*
         *   Your code goes here
         */

        return null;
    }

    /**
     * Add aMatrix to this matrix.
     *
     * @param other SparseMatrix to be added
     * @return a new SparseMatrix object that is the sum of this matrix and other matrix
     * @throws IllegalArgumentException if the size of the matrix doesn't match
     */
    @Override
    public SparseMatrix add(SparseMatrix other) {
        if (this.getRowCount() != other.getRowCount() || this.getColumnCount() != other.getColumnCount())
            throw new IllegalArgumentException("Matrix size doesn't match");

        /*
         *  Your code goes here
         */

        return null;
    }

    /**
     * Multiply this matrix with other matrix.
     * YOU DON'T HAVE TO IMPLEMENT THIS METHOD.
     *
     * @param other a SparseMatrix to be multiplied
     * @return a new SparseMatrix object that is the product of this matrix and other matrix
     * @throws IllegalStateException if dimensions of the matrices are not compatible for multiplication
     */
    @Override
    public SparseMatrix multiply(SparseMatrix other) {
        throw new IllegalStateException("Not implemented");
    }

    /**
     * Get the array of Entry objects.
     *
     * @return the array of Entry objects
     */
    public Entry[] getElements() {
        return elements;
    }

    /**
     * Get the number of rows of the matrix.
     *
     * @return the number of rows of the matrix
     */
    @Override
    public int getRowCount() {
        /*
         *  Your code goes here
         */
        return 0;
    }

    /**
     * Get the number of columns of the matrix.
     *
     * @return the number of columns of the matrix
     */
    @Override
    public int getColumnCount() {
        /*
         *  Your code goes here
         */
        return 0;
    }

    /**
     * Get the number of non-zero elements in the matrix.
     *
     * @return the number of non-zero elements in the matrix
     */
    @Override
    public int getElemCount() {
        /*
         *  Your code goes here
         */
        return 0;
    }

    /**
     * Compares this ArraySparseMatrix object with the specified object for equality.
     *
     * @param obj The object to compare.
     * @return true if the specified object is equal to this ArraySparseMatrix object; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArraySparseMatrix other)) return false;

        if (getRowCount() != other.getRowCount()
                || getColumnCount() != other.getColumnCount()
                || getElemCount() != other.getElemCount())
            return false;

        for (int i = 0; i < elements.length; i++) {
            if (!elements[i].equals(other.elements[i])) return false;
        }
        return true;
    }

    /**
     * DO NOT MODIFY THIS METHOD!!!
     * Returns a string representation of the ArraySparseMatrix object.
     *
     * @return a string representation of the ArraySparseMatrix object
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // print meta
        builder.append(elements[0].getRow() + "\t" + elements[0].getCol() + "\t" + (int) elements[0].getValue() + "\n");

        // print elements
        for (int i = 1; i <= getElemCount(); i++)
            builder.append(elements[i] + "\n");

        return builder.toString();
    }
}
```

#### Implementation Guidelines

- You can freely modify the body of each method to complete the code. You can also freely
add `private` fields and methods if necessary. **However, no given `public` method signatures should be changed**.
- You should check the correctness of your program by running test code, `SparseMatricTest.java`

### What to submit?

- Your source codes archived in `.zip` or `.jar` format.
    - Subject: Homework#1, Section [A|B], 성명, 학번
    - Email to your TA (김정인, rkrkrk24@hanyang.ac.kr)
