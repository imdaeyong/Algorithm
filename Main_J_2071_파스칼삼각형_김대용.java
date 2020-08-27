package jungol_beginner;

import java.util.Scanner;	

public class Main_J_2071_파스칼삼각형_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == j) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
		}
		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			break;
		case 2:
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (i < j) {
						System.out.print(" ");
					} else {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[n - 1 - j][n - 1 - i] + " ");
				}
				System.out.println();
			}

			break;

		}sc.close();

	}
}
