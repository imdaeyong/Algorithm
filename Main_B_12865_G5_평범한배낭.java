package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_12865_G5_평범한배낭 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int w[] = new int[N];
		int v[] = new int[N];
		int dp[][] = new int[N+1][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i]= Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i=0; i<N; i++) { //물건 개수
			for(int j=1; j<=K; j++) {// 무게
				if(w[i]<=j) {
					dp[i+1][j] = Math.max(v[i]+dp[i][j-w[i]], dp[i][j]);
				}else {
					dp[i+1][j] = dp[i][j];
				}
				result = Math.max(dp[i+1][j],result);
				
			}
		}
		System.out.println(result);
		
	}
}
