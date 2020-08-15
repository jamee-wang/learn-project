package org.jamee.learn.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeapSortTest {

    @Test
    public void test_Sort() {
        List<Integer> arrays = new ArrayList<>();
        int size = 100;
        for (int i = 0; i < size; i++) {
            arrays.add(i);
        }
        Collections.shuffle(arrays);

        List<Integer> ascArray = HeapSort.sort(arrays, true);
        Integer first = ascArray.get(0);
        for (int i = 1; i < ascArray.size(); i++) {
            Integer second = ascArray.get(i);
            assertTrue(first <= ascArray.get(i));
            first = second;
        }

        List<Integer> descArray = HeapSort.sort(arrays, false);
        first = descArray.get(0);
        for (int i = 1; i < descArray.size(); i++) {
            Integer second = descArray.get(i);
            assertTrue(first >= descArray.get(i));
            first = second;
        }
    }

    @Test
    public void test_TopK() {
        List<Integer> arrays = new ArrayList<>();
        int size = 10000;
        int k = 100;
        List<Integer> topKExpect = new ArrayList<>(k);
        List<Integer> minKExpect = new ArrayList<>(k);
        for (int i = 0; i < size; i++) {
            arrays.add(i);
            if (i < k) {
                minKExpect.add(i);
            }
            if (i >= size - k) {
                topKExpect.add(i);
            }
        }
        Collections.shuffle(arrays);

        List<Integer> topK = HeapSort.topK(arrays, k);
        assertEquals(topKExpect.size(), topK.size());
        for (Integer e : topK) {
            assertTrue(topKExpect.contains(e));
        }
        List<Integer> minK = HeapSort.minK(arrays, k);
        assertEquals(minKExpect.size(), minK.size());
        for (Integer e : minK) {
            assertTrue(minKExpect.contains(e));
        }
    }
}
