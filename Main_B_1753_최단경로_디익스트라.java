package house_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Main_B_1753_최단경로_디익스트라 {
	static class Edge {
		int v, weight;

		Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;

		List<Edge>[] adj = new ArrayList[V];
		
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			adj[Integer.parseInt(st.nextToken()) - 1]
					.add(new Edge(Integer.parseInt(st.nextToken()) - 1, 
								  Integer.parseInt(st.nextToken())));
		}
		int[] D = new int[V];
		Arrays.fill(D, 999999999);
		boolean[] check = new boolean[V];

		D[K] = 0;
		for (int i = 0; i < V - 1; i++) {
			int min = 999999999; 
			int index = -1; 
			for (int j = 0; j < V; j++) { 
				if (!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			// 연결이 없는경우 끝
			if (index == -1)
				break;

			// 새로운 친구로부터 갈수있는 경로들을 업데이트
			for (Edge next : adj[index]) {
				if (!check[next.v] && D[next.v] > D[index] + next.weight) {
					D[next.v] = D[index] + next.weight;
				}
			}
			// 처리된놈으로 체크
			check[index] = true;
		}
		for (int i = 0; i < V; i++) {
			if (D[i] < 999999999) {
				System.out.println(D[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}
