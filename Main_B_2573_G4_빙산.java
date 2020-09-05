package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_B_2573_G4_빙산 {
    
	    public static int N;
	    public static int M;
	    public static int[][] map;
	    public static int[][] map2;
	    
	    public static int bergCount;
	    
	    public static int[] dy = {-1, 1, 0, 0};
	    public static int[] dx = {0, 0, -1, 1};
	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        map = new int[N][M];
	        map2 = new int[N][M];
	        
	        for(int i=0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for(int j=0; j < M; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	                
	                if(map[i][j] > 0) bergCount++;
	            }
	        }
	        // 입력 및 초기화 완료
	        int year = 0;
	        int linkedCnt = 0;
	        
	        while((linkedCnt = getLinkedCnt()) < 2) {
	            // 연결된 빙하가 없으면 다 녹아버린것..
	            if(linkedCnt == 0) {
	                year = 0;
	                break;
	            }
	            year++;
	            // 빙하를 녹인다.
	            for(int i=0; i < N; i++) {
	                for(int j=0; j < M; j++) {
	                    if(map[i][j] > 0) {
	                        map2[i][j] = Math.max(map[i][j] - nextYear(i, j), 0);
	                    }
	                }
	            }
	            
	            // 결과를 복사한다.
	            for(int i=0; i < N; i++) {
	                for(int j = 0 ; j < M; j++) {
	                    map[i][j] = map2[i][j];
	                }
	            }
	        }
	        
	        System.out.println(year);
	    }
	    public static void dfs(int y, int x, boolean[][] visited) {
	        visited[y][x] = true;
	        
	        for(int i=0; i < 4; i++) {
	            int yy = dy[i] + y;
	            int xx = dx[i] + x;
	            if(yy >= 0 && xx >= 0 && yy < N && xx < M) {
	                if(!visited[yy][xx] && map[yy][xx] > 0) {
	                    dfs(yy,xx, visited);
	                }
	            }
	        }
	    }
	    
	    public static int getLinkedCnt() {
	        int cnt = 0;
	        boolean[][] visited = new boolean[N][M];
	        for(int i=0; i < N; i++) {
	            for(int j=0; j < M; j++) {
	                if(map[i][j] > 0 && !visited[i][j]) {
	                    dfs(i, j, visited);
	                    cnt++;
	                }
	            }
	        }
	        return cnt;
	    }
	    
	    public static int nextYear(int y, int x) {
	        int cnt = 0;
	        if(map[y][x] > 0) {
	            for(int i=0; i <4; i++) {
	                int yy = dy[i] + y;
	                int xx = dx[i] + x;
	                
	                if(yy >= 0 && xx >= 0 && yy < N && xx < M) {
	                    if(map[yy][xx] == 0) cnt++;
	                }
	            }
	        }
	        return cnt;
	    }
	    
	    public static void print(int year) {
	        System.out.println(year + "year");
	        for(int i=0; i < N; i++) {
	            for(int j = 0 ; j < M; j++) {
	                System.out.print(map[i][j] + " ");
	            }
	            System.out.println("");
	        }
	    }
	}
	 
 