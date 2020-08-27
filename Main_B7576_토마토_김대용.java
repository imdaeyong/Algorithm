
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B7576_토마토_김대용 {
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int m;
	static int n;
	static int[][] map;
	static int cnt;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					q.offer(new int[] { i, j });

				}
			}
		}

		cnt = -1;
		tomato();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.printf("%3d",map[i][j]);
				if(map[i][j]==0) cnt=-1;
			}System.out.println();
		}
		
		System.out.println(cnt);
	}

	private static void tomato() {
		int size;
		while (!q.isEmpty()) {
			size = q.size();
			while (size-- > 0) {
				int[] mato = q.poll();
				int y = mato[0];
				int x = mato[1];
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
						if (map[ny][nx] == 0) {
							map[ny][nx] = map[y][x]+1;
							q.offer(new int[] { ny, nx });
						}
					}
				}
			}
			cnt++;
		}
	}
}