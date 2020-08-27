import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_B_16234_인구이동2 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N;
	static int minGap;
	static int maxGap;
	static int[][] map;
	static boolean[][] moved;
	static boolean isQuit;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void BFS(int x, int y) {
		boolean check[][] = new boolean[N + 2][N + 2];
		Queue<Pos> queue = new LinkedList();
		Queue<Pos> queue_tmp = new LinkedList();
		queue.offer(new Pos(x, y));
		int sum = 0;
		while (!queue.isEmpty()) {
			Pos cur_pos = queue.poll();
			check[cur_pos.x][cur_pos.y] = true;
			sum += map[cur_pos.x][cur_pos.y];
			queue_tmp.offer(new Pos(cur_pos.x, cur_pos.y));
			for (int i = 0; i < 4; i++) {
				Pos next_pos = new Pos(cur_pos.x + dx[i], cur_pos.y + dy[i]);
				int gap = Math.abs(map[cur_pos.x][cur_pos.y] - map[next_pos.x][next_pos.y]);
				if (map[next_pos.x][next_pos.y] != 0 // 경계가 아니면서
						&& !moved[next_pos.x][next_pos.y] // 아직 인구이동이 되지 않은 지역이면서
						&& !check[next_pos.x][next_pos.y] // <<BFS방문체크>>
						&& gap >= minGap && gap <= maxGap) { // 인구 차이가 범위 내인 경우
					queue.offer(next_pos); // 큐에 넣어준다.
					check[next_pos.x][next_pos.y] = true;
				}
			}
		}
		// 인구이동이 일어난 경우
		if (queue_tmp.size() != 1) {
			isQuit = false;
			int value = sum / queue_tmp.size();
			while (!queue_tmp.isEmpty()) {
				Pos pos = queue_tmp.poll();
				map[pos.x][pos.y] = value;
				moved[pos.x][pos.y] = true;
			}
		}
	}

	   public static void main(String[] args) throws IOException{
	       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	       String[] input = in.readLine().split(" ");
	       N = Integer.parseInt(input[0]);
	       minGap = Integer.parseInt(input[1]);
	       maxGap = Integer.parseInt(input[2]);
	
	       map = new int[N+2][N+2];
	       moved = new boolean[N+2][N+2];
	       for(int i=1; i<=N; i++){
	           String line[] = in.readLine().split(" ");
	           for(int j=1; j<=N; j++)
	               map[i][j] = Integer.parseInt(line[j-1]);
	      }
	
	       int result = 0;
	       while(true){
	           isQuit = true;
	           for(int i=1; i<=N ;i++)
	               for (int j = 1; j <= N; j++)
	                   if (!moved[i][j])
	                       BFS(i, j);
	
	           if(!isQuit){
	               ++result;
	               // 인구이동여부 초기화
	               for(int i=1; i<=N; i++)
	                   for(int j=1; j<=N; j++)
	                       moved[i][j] = false;
	          } else{ // 인구이동 하나도 없을 시 종료
	               break;
	          }
	      }
	
	       System.out.println(result);
	  }
	}