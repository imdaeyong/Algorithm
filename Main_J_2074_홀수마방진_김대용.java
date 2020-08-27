package jungol_beginner;

import java.util.Scanner;

public class Main_J_2074_홀수마방진_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		int y = 0;
		int x = n / 2;
		int cnt = n * n;

		for (int i = 1; i <= cnt; i++) {
			arr[y][x] = i;
			if (i % n == 0) {
				y++;
			} else {
				if (x == 0) {
					x = n - 1;
				} else {
					x--;
				}

				if (y == 0) {
					y = n - 1;
				} else {
					y--;
				}
			}

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
