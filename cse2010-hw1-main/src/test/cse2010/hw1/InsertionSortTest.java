package cse2010.hw1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void should_create_an_array_of_a_given_length() {
        // Given
        // When
        String[] xs = new String[10];

        // Then
        assertEquals(10, xs.length);

        // When
        String[] ys = new String[0];

        // Then
        assertEquals(0, ys.length);
    }

    @Test
    void should_be_empty_if_empty_array_sorted() {
        // Given
        int[] xs = {};
        int[] expected = {};

        // When
        InsertionSort.isort(xs);

        // Then
        assertTrue(Arrays.equals(expected, xs));
    }

    @Test
    void should_not_be_changed_if_singleton_array_sorted() {
        // Given
        int[] xs = {42};
        int[] expected = {42};

        // When
        InsertionSort.isort(xs);

        // Then
        assertArrayEquals(expected, xs);
    }

    @Test
    void should_be_in_non_increasing_order_if_array_sorted() {
        // Given
        int[] xs = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};

        // When
        InsertionSort.isort(xs);

        // Then
        assertArrayEquals(expected, xs);
    }

    @Test
    void should_not_be_changed_if_already_sorted_in_non_increasing_order() {
        // Given
        int[] xs = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};

        // When
        InsertionSort.isort(xs);

        // Then
        assertArrayEquals(expected, xs);
    }

    @RepeatedTest(10)
    void should_be_in_non_increasing_order_if_array_sorted2() {
        // Given
        Random random = new Random();
        int[] xs = random.ints(random.nextInt(100), 0, 100).toArray();

        // When
        InsertionSort.isort(xs);

        // Then
        for (int i = 0; i < xs.length - 1; i++) {
            assertTrue(xs[i] >= xs[i + 1]);
        }
    }
}