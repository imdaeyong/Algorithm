package jungol_beginner;

import java.util.Scanner;

public class Main_B_1856_숫자사각형2_김대용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 1;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i%2==0) {
					arr[i][j]=cnt++;
				}else {
					arr[i][m-1-j]=cnt++;
				}			
			}			
		}
		for(int i=0; i<n; i++){
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		sc.close();
	}
}
