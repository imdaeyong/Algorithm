import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_16234_인구이동 {
	static int N, L, R;;
	static int[][] map;
	static boolean[][] move;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static boolean flag;

	static class point {
		int y;
		int x;

		public point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 2][N + 2];
		move = new boolean[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		while (true) {
			flag = true;
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					if (!move[i][j])
						bfs(i, j);

			if (!flag) {
				++result;
				for (int i = 1; i <= N; i++)
					for (int j = 1; j <= N; j++)
						move[i][j] = false;

			} else {
				break;
			}

		}
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		boolean[][] visit = new boolean[N + 2][N + 2];
		Queue<point> q = new LinkedList();
		Queue<point> q2 = new LinkedList();
		q.offer(new point(i, j));

		int sum = 0;
		while (!q.isEmpty()) {
			point now = q.poll();
			int y = now.y;
			int x = now.x;
			visit[y][x] = true;
			sum += map[y][x];
			q2.offer(new point(y, x));

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				int gap = Math.abs(map[y][x] - map[ny][nx]);
				if (map[ny][nx] != 0 && !visit[ny][nx] && !move[ny][nx] && gap >= L && gap <= R) {
					q.offer(new point(ny, nx));
					visit[ny][nx] = true;
				}
			}
		}

		if (q2.size() != 1) {

			flag = false;
			int value = sum / q2.size();
			while (!q2.isEmpty()) {
				point p = q2.poll();
				map[p.y][p.x] = value;
				move[p.y][p.x] = true;
			}
		}
	}
}
