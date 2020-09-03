package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1915_G5_가장큰정사각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] dp = new int[1001][1001];
		int result = 0;
		for (int i = 0; i < n; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 0; j < line.length; j++) {
				dp[i + 1][j + 1] = line[j] - '0';
				if (dp[i + 1][j + 1] != 0) {
					int temp = Math.min(dp[i][j], dp[i][j + 1]);
					dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;
					result = Math.max(result, dp[i + 1][j + 1]);
				}
			}
		}
		System.out.println(result * result);

	}
}
