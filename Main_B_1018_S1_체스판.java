package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1018_S1_체스판 {
	static int N, M, cnt;
	static String[] chess = {"WBWBWBWB","BWBWBWBW",
						 	 "WBWBWBWB","BWBWBWBW",
						 	 "WBWBWBWB","BWBWBWBW",
						 	 "WBWBWBWB","BWBWBWBW",};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String[] map = new String[N];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine();
		}
		int max = 2500;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				cnt=0;
				for (int k = 0; k <8; k++) {
					String line= map[i + k].substring(j, j + 8);
					for(int l=0; l<8; l++) {
						 if(line.charAt(l) == chess[k].charAt(l)){
	                            cnt++;
						 }
					}
				}
				if(cnt > 64-cnt) cnt=64-cnt;
				if(cnt < max) max=cnt;
			}
		}
		System.out.println(max);
	}
}

