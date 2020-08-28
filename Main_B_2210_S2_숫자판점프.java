package restart0827;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main_B_2210_S2_숫자판점프 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] a;
	static List<String> result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		result = new ArrayList<>();
		a = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<5; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				backtrack(a[i][j]+"", i, j);
			}
		}
		System.out.println(result.size());
	}

	public static void backtrack(String str, int y, int x) {
		if (str.length() == 6) {
			if (!result.contains(str)) {
				result.add(str);
			}
			return;
		}
		for (int k = 0; k < 4; k++) {
			int ny = y+dy[k];
			int nx = x+dx[k];
			if (nx>= 0 && nx < 5&& 
				ny>= 0 && ny < 5) {
				String str2 = str+ String.valueOf(a[ny][nx]);
				backtrack(str2,ny, nx);
			}
		}
	}
}