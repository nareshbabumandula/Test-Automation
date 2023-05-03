package com.java.basics;

import java.util.Scanner;

public class ScannerArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the length of the first array:");
		int len1 = s.nextInt();
		int [] arr1 = new int[len1];
		System.out.println("Enter the elements of the first array:");

		for(int i=0; i<len1; i++ ) {
			arr1[i] = s.nextInt();
		}

		System.out.println("Enter the length of the second array:");
		int len2 = s.nextInt();
		int [] arr2 = new int[len2];

		System.out.println("Enter the elements of the second array:");

		for(int i=0; i<len2; i++ ) {
			arr2[i] = s.nextInt();
		}

		System.out.println("Intersection of the two arrays ::");
		int count=0;
		for(int i = 0; i<arr1.length; i++ ) {
			for(int j = 0; j<arr2.length; j++) {
				if(arr1[i]==arr2[j]) {
					//System.out.println(arr2[j]);
					count++;
				}
			}
			
		}
		System.out.println("Count is : " +count);

	}

}
