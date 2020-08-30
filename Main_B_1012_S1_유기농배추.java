package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1012_S1_유기농배추 {

	static int N, M, result;
	static int map[][];
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			result = 0;
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[b][a] = 1;
			}

			bfs();

			System.out.println(result);
		}

	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(new Node(i, j));
					map[i][j] = 2;
					while (!q.isEmpty()) {
						Node node = q.poll();

						for (int n = 0; n < 4; n++) {
							int ny = dy[n] + node.y;
							int nx = dx[n] + node.x;

							if (ny < 0 || nx < 0 || ny >= N || nx >= M)
								continue;

							if (map[ny][nx] == 1) {
								q.add(new Node(ny, nx));
								map[ny][nx] = 2;
							}

						}
					}
					result++;
				}
			}
		}
	}

	
}
