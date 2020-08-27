package jungol_beginner;

import java.util.Scanner;

public class Main_B_1719_º°»ï°¢Çü2_±è´ë¿ë {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0) {
			System.out.println("INPUT ERROR!");
		} else {

			int half = n / 2;
			int m = sc.nextInt();

			switch (m) {
			case 1:
				for (int i = 0; i < half + 1; i++) {
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					for(int j=half; j>0;j--) {
						System.out.print(" ");
					}
					System.out.println();
				}
				for(int i=0;i<half;i++) {
					for(int j=half;j>i;j--) {
						System.out.print("*");
					}
					for(int j=0;j<half;j++) {
						System.out.print(" ");
					}
					System.out.println();
				}
				break;

			case 2:
				for(int i=0; i<half+1; i++) {
					for(int j=0;j<half-i;j++) {
						System.out.print(" ");
					}
					for(int j=0;j<=i;j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(int i=0; i<half; i++) {
					for(int j=0; j<=i;j++) {
						System.out.print(" ");
					}
					for(int j=0; j<half-i;j++) {
						System.out.print("*");
					}
					System.out.println();
				}
		
				break;

			case 3:
				for (int i = 0; i < half + 1; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < n - (i * 2); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = half - 1; i >= 0; i--) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < n - (i * 2); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < half + 1; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < half + 1 - i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = 0; i < half; i++) {
					for (int j = 0; j < half; j++) {
						System.out.print(" ");
					}
					for (int j = half - 1; j <= i + half; j++) {
						System.out.print("*");
					}
					System.out.println();
				}

				break;
			default:
				System.out.println("INPUT ERROR!");
				break;
			}
		}sc.close();
	}
}
