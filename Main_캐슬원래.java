import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_캐슬원래 {
	static int[] attack_y = { 0, -1, 0 };
	static int[] attack_x = { -1, 0, 1 };
	static int a_range;
	static int[][] map;
	static int n;
	static int m;
	static int total_kill;
	static int[] kill;
	static int[] die;
	static HashMap<Integer, int[]> shot = new HashMap<Integer, int[]>();
	static HashMap<Integer, Integer> arc_maker = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a_range = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int arccnt[] = new int[m];
		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {
				if (map[j][i] == 1) {
					arc_maker.put(i, ++arccnt[i]);
				}
			}
			max = max < arccnt[i] ? arccnt[i] : max;
		}
		int cntt = 0;
		int archer[] = new int[3];
		for (int i = max; i > 0; i--) {
			int go = 0;
			while (go < m) {
				if (arccnt[go] == i && cntt < 3) {
					archer[cntt++] = go;
				}
				go++;
			}
		}
		System.out.println(Arrays.toString(archer));

		total_kill = 0;
		kill = new int[m];
		die = new int[2];

		for (int k = 0; k < n; k++) {
			L:
			for (int i = 0; i < m; i++) {
				int archer_cnt=0;
				for (int j = 0; j < 3; j++) {
					if (archer[j] == i) {
						archer(n, i);
//					System.out.println(i + "번궁수" + kill[i] + "kill");
						if (kill[i] == 1) {
							die[0] = shot.get(i)[0];
							die[1] = shot.get(i)[1];
							map[die[0]][die[1]] = 0;
							total_kill++;
							archer_cnt++;
							if(archer_cnt==3) break L;
						}
					}
				}
			}

			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						map[i + 1][j] = 1;
						map[i][j] = 0;

					}
				}
			}
		}
		System.out.println(total_kill);
	}

	private static void archer(int y, int x) {

		int range = a_range;
		kill[x] = 0;

		L: while (range > 0) {
			for (int i = 0; i < 3; i++) {
				int shoot_y = y + attack_y[i];
				int shoot_x = x + attack_x[i];
				if (shoot_y < 0 || shoot_x < 0 || shoot_y >= n || shoot_x >= m) {
					continue;
				}
				if (map[shoot_y][shoot_x] == 1) {
					int[] target = { shoot_y, shoot_x };
					shot.put(x, target);
					kill[x]++;
					break L;
				}
			}
			range--;
		}
	}

}