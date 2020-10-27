package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main_B_9663_G5_NQueen {
    static int map[] = new int[15];
    static boolean []visited = new boolean[15];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	        
        N = Integer.parseInt(in.readLine());
        for (int i =0; i < N; i++) {
            visited[i] = false;
            map[i] = 0;
        }
        System.out.println(dfs(0));
    }
    static int dfs(int queen) {
        int ans = 0;
        if (queen == N) {
            return 1;
        }
        for (int i = 0; i < N; i++){
            if (visited[i]){
                continue;
            }
            if (!next(i, queen)){//대각선
                continue;
            }
            visited[i] = true;
            map[queen] = i;
            ans += dfs(queen+1);
            visited[i] = false;
            map[queen] = 0;
        }
        return ans;
    }
    static boolean next(int y, int x) {
    	for (int i = 0; i < x; i++) {
    		if (Math.abs(map[i] - y)== Math.abs(i - x)){
    			return false;
    		}
    	}
    	return true;
    }
}
