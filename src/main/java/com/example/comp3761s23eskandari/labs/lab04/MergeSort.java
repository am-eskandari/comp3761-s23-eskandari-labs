package com.example.comp3761s23eskandari.labs.lab04;

public class MergeSort {

	static int findMax(int a[], int left, int right) {
		if(left == right)
			return left;
		else {
			int mid = (left + right) / 2;
			int leftMax = findMax(a, left, mid);
			int rightMax = findMax(a, mid+1, right);
			if(a[leftMax] > a[rightMax])
				return leftMax;
			else
				return rightMax;
		}
	}

	static int[] mergeSort(int[] A) {
		if (A.length > 1) {
			int mid = A.length / 2;
			int[] B = java.util.Arrays.copyOfRange(A, 0, mid);
			int[] C = java.util.Arrays.copyOfRange(A, mid, A.length);

			mergeSort(B);
			mergeSort(C);
			merge(B, C, A);
		}
		return A;
	}

	static void merge(int[] B, int[] C, int[] A) {
		int i = 0, j = 0;
		while(i + j < A.length) {
			if(j == C.length || (i < B.length && B[i] < C[j])) {
				A[i+j] = B[i];
				i++;
			} else {
				A[i+j] = C[j];
				j++;
			}
		}
	}

	public static void main(String[]args) {
		int a[] = {2,5,8,3,6,9,1,6,5};
		int b[] = {3,2,7,6,8};
		System.out.printf("Q1) findMax\nMaximum element: position %d\n", findMax(a, 0, a.length - 1) + 1);

		System.out.print("Q2) mergeSort\n");
		System.out.println("Before sort:");

		for(int i = 0; i < b.length; i++)
			System.out.print(b[i] + ", ");

		mergeSort(b);

		System.out.println("\nAfter sort:");

		for(int i = 0; i < b.length; i++)
			System.out.print(b[i] + ", ");
	}
}