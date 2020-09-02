package restart0827;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
public class Main_B_2240_S1_자두나무 {
    static int T, W;
    static int dp[][];
    static int jadu[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        T = Integer.parseInt(tmp[0]);
        W = Integer.parseInt(tmp[1]);
        jadu = new int[T+1];
        dp = new int[T+1][W+1];
         
        for(int i = 1; i <= T; i++){
            jadu[i] = Integer.parseInt(br.readLine());
        }
         
         
        //탐색 시작
        if(jadu[1] == 1){
            dp[1][0] = 1;
        }else{
            dp[1][1] = 1;
        }
 
        for(int i = 2; i <= T; i++){
            for(int j = 0; j <=W; j++){
                if(j == 0){
                    dp[i][0] = jadu[i] == 1 ? dp[i-1][0] + 1 : dp[i-1][0];
                }else{
                    if(j % 2 == 0){//짝수번 이동했으면 1번
                        dp[i][j] = jadu[i] == 1 ? Math.max(dp[i-1][j-1], dp[i-1][j]) + 1 : dp[i-1][j];
                    } else{//홀수번 이동 2번
                        dp[i][j] = jadu[i] == 2 ? Math.max(dp[i-1][j-1], dp[i-1][j]) + 1 : dp[i-1][j];
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= W; i++){
            ans = ans > dp[T][i] ? ans : dp[T][i];
        }
        System.out.println(ans);
    }
}


