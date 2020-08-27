package jungol_beginner;

import java.util.Scanner;

public class Main_J_2046_숫자사각형4_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 1;
		int[][] arr = new int[n][n];
		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = i + 1;
				}
			}

			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i % 2 == 0) {
						arr[i][j] = j + 1;
					} else {
						arr[i][n - j - 1] = j + 1;
					}
				}
			}

			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = (j + 1) * (i + 1);
				}
			}

			break;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
