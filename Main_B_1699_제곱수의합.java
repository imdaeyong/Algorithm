package house_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_1699_제곱수의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		int[] dp = new int[n+1];
		for(int i=1; i<=n;i++) dp[i]=i; //1의 제곱으로만 채운게 default
		for(int i=2; i<=n;i++) {
			for(int j=2;j*j<=i;j++) {
				dp[i]=Math.min(dp[i],dp[i-j*j-1]);
			}
		}
		
		System.out.println(dp[n]);
	}
}


