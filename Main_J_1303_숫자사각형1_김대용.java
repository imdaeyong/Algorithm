package jungol_beginner;

import java.util.Scanner;

public class Main_J_1303_숫자사각형1_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(cnt + " ");
				cnt++;
			}
			System.out.println();
		}
		sc.close();
	}
}
