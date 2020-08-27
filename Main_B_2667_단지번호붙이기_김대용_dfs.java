import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2667_단지번호붙이기_김대용_dfs{
	static int n;
	static boolean[][] visited;
	static int[][] map;
	static int cnt;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("numbering.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		cnt = 0;
		ArrayList<Integer> q = new ArrayList<Integer>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String line = st.nextToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cnt = 0;
				if (map[i][j] != 1 || visited[i][j] == true)
					continue;
				dfs(i, j);
				if (cnt > 0) {
					result++;
					q.add(cnt);
				}
			}
		}
		Collections.sort(q);
		System.out.println(result);
		for (int i = 0; i < q.size(); i++) {
			System.out.println(q.get(i));
		}
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		cnt++;

		for (int k = 0; k < 4; k++) {
			int nexty = y + dy[k];
			int nextx = x + dx[k];
			if (nexty < 0 || nextx < 0 || nexty >= n || nextx >= n)
				continue;
			if (map[nexty][nextx] == 0 || visited[nexty][nextx])
				continue;

			dfs(nexty, nextx);
		}
	}
}
