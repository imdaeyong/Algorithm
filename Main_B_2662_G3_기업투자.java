package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_2662_G3_기업투자 {
    public static int N, M;
    public static int[][] company;
    public static int[][] money;
    public static int[][] dp;
    public static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        company = new int[M+1][N+1];
        money = new int[N+1][M+1];
        dp = new int[M+1][N+1];

        for(int i = 0; i < M; ++i) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 1; i <= N; ++i) {
            st = new StringTokenizer(in.readLine());
            st.nextToken();
            for(int j = 0; j < M; ++j) {
                money[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(0, N));
        int left = N;
        for(int i = 0; i < M; ++i) {
        	System.out.print(company[i][left] + " ");
            left -= company[i][left];
        }
    }

    public static int solve(int index, int left) {
        if(index == M) return 0;
        if(dp[index][left] != -1) return dp[index][left];
        dp[index][left] = 0;
        int temp;
        for(int i = 0; i <= left; ++i) {
        	solve(index+1,left-i);
            temp = solve(index + 1, left - i) + money[i][index];
            if(dp[index][left] < temp) {
                dp[index][left] = temp;
                company[index][left] = i;
            }
        }
        return result = dp[index][left];
    }
}