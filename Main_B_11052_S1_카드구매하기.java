package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_11052_S1_카드구매하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int[] prices = new int[N+1];
		for (int i = 0; i<N; i++) {
			prices[i+1] = Integer.parseInt(st.nextToken());
		}

		int[] d = new int[N+1];

		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <= i; j++) {
				if (d[i] < d[i - j] + prices[j]) {
					d[i] = d[i - j] + prices[j];
				}
			}
		}
	}
}
