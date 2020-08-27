package jungol_beginner;

import java.util.Scanner;

public class Main_J_1523_별삼각형1_김대용_PART {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n > 100) {
			System.out.println("INPUT ERROR!");
		}
		int m = sc.nextInt();
		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;

		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

			break;

		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <n-i-1; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<=i;j++) {
					System.out.print("*");
				}
				for(int j=0; j<i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}

			break;
		default:
			System.out.println("INPUT ERROR!");
			break;
		}

		sc.close();
	}
}
