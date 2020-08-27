package jungol_beginner;

import java.util.Scanner;

public class Main_B_1337_´ÞÆØÀÌ»ï°¢Çü_±è´ë¿ë_ING {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] snail = new int[n][n];
		int x = 0;
		int y = 0;
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = n-1; j >=i; j--) {
				if (cnt > 9) {
					cnt = 0;
				}
				snail[y][x] = cnt++;
				if (j==i) {
					break;
				} else {
					if (i % 3 == 0) {
						x++;
						y++;
					} else if (i % 3 == 1) {
						x--;
					} else {
						y--;
					}
				}
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}

	}
}
