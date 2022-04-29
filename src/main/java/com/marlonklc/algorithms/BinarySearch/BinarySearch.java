package com.marlonklc.algorithms.BinarySearch;

import java.util.Optional;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("when element found return index of element => " + binarySearch(3, array));
        System.out.println("when element not found return empty => " + binarySearch(99, array));

        int[] arrayWithDuplicatedIndexes = new int[] {1,2,2,3,3,4,5,6,7,7,8,9,10,10};
        System.out.println("when element found but having duplicated indexes, must be return the first index of element => " + binarySearch(10, arrayWithDuplicatedIndexes));
    }

    // I added this method to facilitate of use with simple method
    public static Optional<Integer> binarySearch(int searchedElement, int... elements) {
        return binarySearch(searchedElement, 0, elements.length - 1, elements);
    }

    /*
        PS: so that the binary search works correctly, the list/array/elements must me order by element position.
            so, first thing before you start the binary search, ALWAYS order the elements
     */
    private static Optional<Integer> binarySearch(int searchedElement, int startIndex, int endIndex, int... elements) {
        if (startIndex < endIndex) {
            int middleIndex  = (startIndex + endIndex) >> 1;
           //int middleIndex  = (startIndex + endIndex) / 2;

            if (elements[middleIndex] == searchedElement) return Optional.of(middleIndex);

            boolean mustBeSearchedOnLeftSideOfElements = searchedElement < elements[middleIndex];
            if (mustBeSearchedOnLeftSideOfElements) {
                return binarySearch(searchedElement, startIndex, middleIndex - 1, elements);
            } else {
                return binarySearch(searchedElement, middleIndex + 1, endIndex, elements);
            }
        }

        return Optional.empty();
    }
}
