package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_10836_G4_여왕벌 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int M = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int cnt_0 = Integer.parseInt(st.nextToken()); 
			int cnt_1 = Integer.parseInt(st.nextToken()); 
			int cnt_2 = Integer.parseInt(st.nextToken()); 
			
			for (int y = M-1; y >=0; y--) {
				if(cnt_0!=0) cnt_0--;
				else if(cnt_1!=0) {
					map[y][0]++;
					cnt_1--;
				}else if(cnt_2!=0) {
					map[y][0] += 2;
					cnt_2--;
				}
			}
			for (int x = 1; x < M; x++) {
				if(cnt_0!=0) cnt_0--;
				else if(cnt_1!=0) {
					map[0][x]++;
					cnt_1--;
				}else if(cnt_2!=0) {
					map[0][x] += 2;
					cnt_2--;
				}
			}
		}
		
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				int temp=0;
				if(map[i-1][j]>map[i][j-1]) {
					temp = Math.max(map[i-1][j], map[i-1][j-1]);
				}else {
					temp = Math.max(map[i][j-1], map[i-1][j-1]);
				}
				map[i][j]=temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}