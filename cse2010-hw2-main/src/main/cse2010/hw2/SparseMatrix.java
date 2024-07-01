package cse2010.hw2;

public interface SparseMatrix {

    SparseMatrix transpose();

    SparseMatrix add(SparseMatrix aMatrix);

    SparseMatrix multiply(SparseMatrix aMatrix);

    int getRowCount();

    int getColumnCount();

    int getElemCount();
}
