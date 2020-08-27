package jungol_beginner;

import java.util.Scanner;

public class Main_J_2813_소수의개수_김대용_TLE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int cnt = 0;		
		
		long start = System.currentTimeMillis();

		for (int i = m; i <= n; i++) {
			for (int j = 2; j <= i; j++) {
				if (j>i/2) {
					cnt++;
					break;
				}if (i % j == 0) {
					break;
				}
			}
		}
		System.out.println(cnt);

		long end = System.currentTimeMillis();
//		System.out.println("수행시간 : " + (end - start));
	}
}
