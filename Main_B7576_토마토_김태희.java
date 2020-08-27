

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B7576_토마토_김태희 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int map[][], N, M;
	static Queue<Point> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		queue = new LinkedList<Point>();
		map = new int[N][M];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					sum++;
					queue.offer(new Point(i, j));
				}
			}
		}

		if (sum == N * M) {// 모두 익어 있다면
			System.out.println(0);
		} else if (sum == 0) {// 모두 익어 있지 않다면
			System.out.println(-1);
		} else {
			int res = bfs();
			System.out.println(res == -1 ? -1 : res - 1);
		}
	}

	private static int bfs() {
		Point p;
		int nx = 0, ny = 0;
		while (!queue.isEmpty()) {
			p = queue.poll();

			for (int d = 0; d < 4; d++) {
				nx = p.x + dx[d];
				ny = p.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = map[p.x][p.y] + 1; // 토마토가 익는데 걸린 날짜에 하루를 더한다.
					queue.offer(new Point(nx, ny));
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return -1;
				}
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		return max;
	}
}