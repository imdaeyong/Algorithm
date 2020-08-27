package com.ssafy.divide;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2630_색종이만들기_김대용 {
	static int n;
	static int[][] map;
	static int white;
	static int blue;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(map);
		System.out.println(white);
		System.out.println(blue);

	}

	private static void check(int[][] cmap) {
		int perfect = 2;
		L:for (int i = 0; i < cmap.length; i++) {
			for (int j = 0; j < cmap.length; j++) {
				perfect = cmap[0][0];
				if (perfect != cmap[i][j]) { // 다 같지 않으면?
					perfect = 2;
					break L;
				}
			}
		}
		int h = cmap.length/2;		

		if (perfect == 0) {
			white++;
			return;
		} else if (perfect == 1) {
			blue++;
			return;
		}		
			check(divide1(cmap, h));
			check(divide2(cmap, h));
			check(divide3(cmap, h));
			check(divide4(cmap, h));
	}

	private static int[][] divide1(int[][] cmap, int half) {
		int[][] map1 = new int[half][half];

		for (int i = 0; i < half; i++) {
			for (int j = 0; j < half; j++) {
				map1[i][j] = cmap[i][j];
			}
		}
		return map1;
	}

	private static int[][] divide2(int[][] cmap, int half) {
		int[][] map1 = new int[half][half];
		for (int i = 0; i < half; i++) {
			for (int j = 0; j < half; j++) {
				map1[i][j] = cmap[i][half + j];
			}
		}
		return map1;
	}

	private static int[][] divide3(int[][] cmap, int half) {
		int[][] map1 = new int[half][half];
		for (int i = 0; i < half; i++) {
			for (int j = 0; j < half; j++) {
				map1[i][j] = cmap[half + i][j];
			}
		}
		return map1;
	}

	private static int[][] divide4(int[][] cmap, int half) {
		int[][] map1 = new int[half][half];
		for (int i = 0; i < half; i++) {
			for (int j = 0; j < half; j++) {
				map1[i][j] = cmap[half + i][half + j];
			}
		}
		return map1;
	}
}
