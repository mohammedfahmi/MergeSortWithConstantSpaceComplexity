package Algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MergeSortTest {
    @Test
    public void testSort() {
        List input = Arrays.asList(30,14,2,5,3,5,2,4,6,2,5,8,9,1);
        ArrayList<Integer> unsortedList = new ArrayList<Integer>(input);
        ArrayList<Integer> sortedList = new ArrayList<Integer>(input);
        Collections.sort(sortedList);
        ArrayList<Integer> result = MergeSort.sort(unsortedList);
        Assertions.assertArrayEquals(sortedList.toArray(), result.toArray());
    }
}