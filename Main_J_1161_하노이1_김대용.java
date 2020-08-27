package jungol_beginner;

import java.util.Scanner;

public class Main_J_1161_하노이1_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char go_1 = '1';
		char go_2 = '2';
		char go_3 = '3';
		hanoi(n, go_1, go_2, go_3);
		sc.close();
	}

	public static void hanoi(int n, char go_1, char go_2, char go_3) {

		if (n == 1) {
			System.out.println(n + " : " + go_1 + " -> " + go_3);
		} else {
			hanoi(n - 1, go_1, go_3, go_2);
			System.out.println(n + " : " + go_1 + " -> " + go_3);
			hanoi(n - 1, go_2, go_1, go_3);
		}
	}
}
