
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_17135_캐슬디펜스 {

	static int[] a_y = { 0, -1, 0 };
	static int[] a_x = { -1, 0, 1 };
	static int[][] map;
	static int a_r;
	static int n;
	static int m;
	static int total_kill;
	static int[] shooter;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a_r = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] pick = new int[m];
		pick[m - 1] = pick[m - 2] = pick[m - 3] = 1;

		shooter = new int[3];
		int cnt = 0;
		do {
			for (int i = 0; i < pick.length; i++) {
				if (pick[i] == 1) {
					shooter[cnt++] = i;
				}

				shoot();
				System.out.print(i + " ");

			}
			System.out.println();
		} while (archer(pick));
		total_kill = 0;
	}

	private static void shoot() {
		int y = n - 1;
		int range = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int s = 0; s < 3; s++) {
			while (range <= a_r) {
				for (int i = 0; i < 3; i++) {
					int s_y = y + a_y[i];
					int s_x = shooter[s] + a_x[i];
					if (s_y >= 0 && s_x >= 0 && s_y < n && s_x < m) {
						if (map[s_y][s_x] == 1) {
							q.offer(new int[] { s_y, s_x });
						}
					}
				}
			} // 사거리 조절
		}
	}

	private static boolean archer(int[] p) {
		int N = p.length;
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		int k = N - 1;
		while (i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;

			i++;

			k--;

		}

		return true;

	}

}