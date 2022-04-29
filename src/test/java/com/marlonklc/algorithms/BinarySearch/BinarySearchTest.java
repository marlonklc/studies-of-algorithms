package com.marlonklc.algorithms.BinarySearch;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.marlonklc.algorithms.BinarySearch.BinarySearch.binarySearch;
import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    @Test
    public void havingSearchByWrongIndexShouldReturnNoIndexFound() {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};

        Optional<Integer> result = binarySearch(11, array);

        assertThat(result).isEmpty();
    }

    @Test
    public void havingEmptyElementsShouldReturnNoIndexFound() {
        int[] array = new int[0];

        Optional<Integer> result = binarySearch(9, array);

        assertThat(result).isEmpty();
    }

    @Test
    public void havingElementsDuplicatedIndexesShouldReturnIndexOfFirstElementFound() {
        int[] array = new int[] {1,2,3,3,4,5,6,7,7,8,9,10,10,10,10,10,10,10};

        Optional<Integer> result = binarySearch(10, array);

        assertThat(result).get().isEqualTo(13);
    }

    @Test
    public void havingJustTwoElementsShouldReturnElementIndex() {
        int[] array = new int[] {1,10};

        Optional<Integer> result = binarySearch(1, array);

        assertThat(result).get().isEqualTo(0);
    }

    @Test
    public void havingJustTwoElementsAndSearchByRightSideShouldReturnNoIndexFound() {
        int[] array = new int[] {1,10};

        Optional<Integer> result = binarySearch(10, array);

        assertThat(result).isEmpty();
    }

    @Test
    public void havingJustTwoElementsAndSearchByWrongIndexShouldReturnNoIndexFound() {
        int[] array = new int[] {1,10};

        Optional<Integer> result = binarySearch(5, array);

        assertThat(result).isEmpty();
    }
}
