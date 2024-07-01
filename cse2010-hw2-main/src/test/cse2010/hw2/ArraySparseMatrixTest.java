package cse2010.hw2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArraySparseMatrixTest {

    @Test
    void should_create_sparseMatrix_from_2DArray() {
        // Arrange (Given)
        double[][] input = {
                {0, 0, 1.0, 0},
                {1.0, 2.0, 0, 0},
                {0, 0, 0, 3.0}
        };

        Entry[] sparseMatrix = {
                new Entry(3, 4, 4),
                new Entry(0, 2, 1.0),
                new Entry(1, 0, 1.0),
                new Entry(1, 1, 2.0),
                new Entry(2, 3, 3.0)
        };

        // Act (When)
        SparseMatrix result = ArraySparseMatrix.from(input);

        // Assert (Then)
        assertAll("Check sparse matrix creation",
                () -> assertEquals(4, result.getElemCount()),
                () -> assertEquals(3, result.getRowCount()),
                () -> assertEquals(4, result.getColumnCount()),
                () -> assertArrayEquals(sparseMatrix, ((ArraySparseMatrix) result).getElements(), "Sparse matrix construction fail")
        );
    }

    @Test
    void should_add_two_matrices() {
        //Given
        double[][] m1 = {
                {0, 0, 1.0, 0},
                {1.0, 2.0, 0, 0},
                {0, 0, 0, 3.0}
        };

        double[][] m2 = {
                {1.0, 0, 0, 2.0},
                {0, 3.0, 0, 0},
                {4.0, 0, 5.0, 0}
        };

        double[][] output = {
                {1.0, 0, 1.0, 2.0},
                {1.0, 5.0, 0, 0},
                {4.0, 0, 5.0, 3.0}
        };

        SparseMatrix expectedMatrix = ArraySparseMatrix.from(output);
        SparseMatrix sm1 = ArraySparseMatrix.from(m1);
        double[][] m1_copy = Arrays.stream(m1).map(double[]::clone).toArray(double[][]::new);
        SparseMatrix sm2 = ArraySparseMatrix.from(m2);
        double[][] m2_copy = Arrays.stream(m2).map(double[]::clone).toArray(double[][]::new);

        // When
        SparseMatrix result = sm1.add(sm2);

        // Then
        assertEquals(expectedMatrix, result, "Addition failed");
        assertEquals(expectedMatrix, sm2.add(sm1), "Addition failed");
        assertArrayEquals(m1, m1_copy, "Addition should not modify the original matrix");
        assertTrue(Arrays.deepEquals(m1, m1_copy)); // same as above test
    }

    @Test
    void should_throw_exception_if_array_dimensions_differ() {
        // Given
        double[][] m1 = {
                {0, 0, 1.0, 0},
                {1.0, 2.0, 0, 0},
                {0, 0, 0, 3.0}
        };

        double[][] m2 = {
                {1.0, 0, 0, 2.0},
                {0, 3.0, 0, 0},
        };

        SparseMatrix sm1 = ArraySparseMatrix.from(m1);
        SparseMatrix sm2 = ArraySparseMatrix.from(m2);

        // When
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> sm1.add(sm2));

        // Then
        assertEquals("Matrix size doesn't match", exception.getMessage());
    }

    @Test
    void should_transpose_matrix() {
        // Given
        double[][] input = {
                {0, 0, 1.0, 0},
                {1.0, 2.0, 0, 0},
                {0, 0, 0, 3.0}
        };

        double[][] output = {
                {0, 1.0, 0},
                {0, 2.0, 0},
                {1.0, 0, 0},
                {0, 0, 3.0}
        };
        SparseMatrix inputMatrix = ArraySparseMatrix.from(input);
        SparseMatrix expectedMatrix = ArraySparseMatrix.from(output);
        double[][] input_copy = Arrays.stream(input).map(double[]::clone).toArray(double[][]::new);

        // When
        final SparseMatrix actualMatrix = inputMatrix.transpose();

        assertEquals(expectedMatrix, actualMatrix, "Transpose failed");
        assertArrayEquals(input, input_copy, "Transpose should not modify the original matrix");
    }
}
