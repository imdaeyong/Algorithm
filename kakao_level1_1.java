package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kakao_level1_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		System.out.println(solution(n));

	}

	public static String solution(int n) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0)
				sb.append("수");
			else
				sb.append("박");
		}
		answer = sb.toString();
		return answer;
	}

}
