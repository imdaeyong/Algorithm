package jungol_beginner;

import java.util.Scanner;

public class Main_J_1304_숫자사각형3_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int cnt = 1;
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {		
				arr[j][i]=cnt++;
			}			
		}
		for(int i=0; i<n; i++){
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		sc.close();
	}
}
