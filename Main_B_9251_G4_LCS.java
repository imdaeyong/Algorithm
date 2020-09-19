package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_9251_G4_LCS {



	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//StringTokenizer st = new StringTokenizer(in.readLine());
		
		String str1 =in.readLine();
		String str2 = in.readLine();

		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int x = 1; x <= str1.length(); x++) {

			char c1 = str1.charAt(x - 1);

			for (int y = 1; y <= str2.length(); y++) {

				char c2 = str2.charAt(y - 1);

				if (c1 == c2) {
					dp[x][y] = dp[x - 1][y - 1] + 1;
				} else {
					dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);

				}
			}
		}
		System.out.println(dp[len1][len1]);
	}
}

