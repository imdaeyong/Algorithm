package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_15686_G4_치킨배달 {
	
	static int N, M, total; 
	static int[][] map; 
	static List<point> houses; 
	static List<point> chickens;
	static point[] combiArr;
	static int[] arr;

	static class point {
		int y, x;

		public point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		total = Integer.MAX_VALUE;

		houses = new ArrayList<point>(); // 집
		chickens = new ArrayList<point>(); // 치킨집

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 집
					houses.add(new point(i, j));
				} else if (map[i][j] == 2) { // 치킨집
					chickens.add(new point(i, j));
				}
			}
		} 

		arr = new int[M]; 
		combi(arr, chickens.size(), M, 0, 0); 
		sb.append(total + "\n");
		System.out.println(sb); // 출력
		br.close();

	}

	//치킨집 거리
	public static int dis(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	// 조합
	private static void combi(int[] arr, int n, int r, int index, int target) {
		if (r == 0) {
			combiArr = new point[M]; 
			for (int i = 0; i < M; i++) {
				combiArr[i] = chickens.get(arr[i]); // 
			}
			search(combiArr); 
			return;
		}
		if (target == n) 
			return;

		arr[index] = target; 
		combi(arr, n, r - 1, index + 1, target + 1);
		combi(arr, n, r, index, target + 1);
	}

	// 치킨집 최소 거리 찾기
	private static void search(point[] combi) {
		int ret = 0;

		for (point i : houses) { 		
			int disMin = Integer.MAX_VALUE; 
			for (point j : combi) { 		
				int retDis = dis(i.y, i.x, j.y, j.x); 
				disMin = Math.min(disMin, retDis); 	
			}
			ret += disMin; 
		}
		total = Math.min(total, ret); 
	}
}