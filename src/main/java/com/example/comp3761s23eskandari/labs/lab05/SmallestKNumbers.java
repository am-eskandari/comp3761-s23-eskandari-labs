package com.example.comp3761s23eskandari.labs.lab05;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestKNumbers {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;

        int[] smallestK = findSmallestKNumbers(numbers, k);

        System.out.print("Smallest " + k + " numbers: ");
        for (int num : smallestK) {
            System.out.print(num + " ");
        }
    }

    static int[] findSmallestKNumbers(int[] numbers, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new MaxComparator());

        for (int num : numbers) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        int[] smallestK = new int[k];
        for (int i = 0; i < k; i++) {
            smallestK[i] = maxHeap.poll();
        }

        return smallestK;
    }

    static class MaxComparator implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
}
