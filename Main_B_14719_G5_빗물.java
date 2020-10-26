package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_14719_G5_빗물 {
    static int H,W;
    static boolean[][] visited;
    static boolean[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new boolean[H][W];
        visited = new boolean[H][W];
        ans = 0;
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<W; i++) {
            int rain = Integer.parseInt(st.nextToken());
            for(int j=0; j<rain; j++)
                map[j][i] = true;
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(map[i][j] &&!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    static void dfs(int y, int x) {
    	int right = x;
    	int rains =0;
        while(true) {
            right++;            
            if(right>=W) break;
            if(map[y][right]) {
                ans += rains;
                break;
            }
            rains++;
            visited[y][right] = true;
        }
    }
}
