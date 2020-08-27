package jungol_beginner;

import java.util.Scanner;

public class Main_J_1002_최대공약최소공배_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		int gcd_num = 0;
		int lcm_num = 1;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				gcd_num = gcd(nums[0], nums[1]);
			} else {
				gcd_num = gcd(gcd_num, nums[i]);
			}
		}
		for (int i = 0; i < N; i++) {
			lcm_num = lcm_num * nums[i] / gcd(lcm_num, nums[i]);
		}
		System.out.print(gcd_num + " ");
		System.out.println(lcm_num);
		sc.close();
	}

	public static int gcd(int a, int b) {
		int temp = 0;
		while (b != 0) {
			temp = a;
			a = b;
			b = temp % b;
		}
		return a;

	}
}
