package restart0827;

/*
 * 메모리 62308kb
 * 시간 220ms
 * 푸는시간 2시간 10분
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_17244_G3_아맞다우산 {
	static char[][] map;
	static boolean visited[][];
	static int N, M;
	static Node[] p;
	static Node[] np;
	static boolean check[];
	static int start_x, start_y,end_x, end_y;
	static int m;
	
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int time[][];
	static int result;
	
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'X') {
					cnt++;

				}
			}
		}
		p = new Node[cnt];
		np = new Node[cnt];
		int k = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'X') {
					p[k] = new Node(i, j);
					k++;
				} else if (map[i][j] == 'S') {
					start_x = i;
					start_y = j;
				} else if (map[i][j] == 'E') {
					end_x = i;
					end_y = j;
				}
			}
		}
		check = new boolean[p.length];
		
		result=Integer.MAX_VALUE;
		dfs(0);
		System.out.println(result);
	}

	public static void bfs(int tmp_x,int tmp_y,int target_x,int target_y) {
		visited=new boolean[N][M];
		time = new int[N][M];
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(tmp_x,tmp_y));
		visited[tmp_x][tmp_y]=true;
		while(!q.isEmpty()) {
			Node p1=q.poll();
			if(p1.x==target_x&&p1.y==target_y) {
				m+=time[p1.x][p1.y];
				return;
			}
			for(int i=0;i<4;i++) {
				int x=p1.x+dx[i];
				int y=p1.y+dy[i];
				if(x>=0&&x<N&&y>=0&&y<M&&map[x][y]!='#'&&!visited[x][y]) {
					visited[x][y]=true;
					time[x][y]=time[p1.x][p1.y]+1;
					q.add(new Node(x,y));
				}
			}
		}
	}
	public static void dfs(int idx) {
		if (p.length == idx) {
			int tmp_x=start_x;
			int tmp_y=start_y;
			m=0;
			for(int i=0;i<np.length;i++) {
				bfs(tmp_x,tmp_y,np[i].x,np[i].y);
				tmp_x=np[i].x;
				tmp_y=np[i].y;
			}
			bfs(tmp_x,tmp_y,end_x,end_y);
			if(result>m)
				result=m;
			return;
		}
		for (int i = 0; i < p.length; i++) {
			if (!check[i]) {
				check[i] = true;
				np[idx] = p[i];
				dfs(idx + 1);
				check[i] = false;
			}
		}
	}
}
