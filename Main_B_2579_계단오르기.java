import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[] memo = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		memo[1] = stair[1]; // 10
		if(N>=2) {
			memo[2] = stair[2] + stair[1]; // 10+20
		}

		int step1, step2;
		if (N >= 3) {
			for (int i = 3; i <= N; i++) {
				step1 = stair[i] + stair[i - 1] + memo[i - 3];
				step2 = stair[i] + memo[i - 2];

				memo[i] = Math.max(step1, step2);
			}
		}
		System.out.println(memo[N]);
	}
}
