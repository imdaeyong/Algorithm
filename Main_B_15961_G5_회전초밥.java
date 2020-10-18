package restart0827;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_15961_G5_회전초밥 {	
	static int front, rear,res;
	static int visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] dish = new int[N];
		visited = new int[D + 1];

		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}


		front = 0;
		rear = K - 1;
		int checked = 0;
		
		visited[C]++;
		for (int i = 0; i < K; i++) { 
			visited[dish[i]]++;
			if (visited[dish[i]] > 1)
				checked++;
		}
		
		res = Math.max(res, K + 1 - checked);

		for (int i = 0; i < N; i++) { 

			visited[dish[front]]--;
			if (visited[dish[front]] > 0)
				checked--;
			front++;
			if (rear + 1 == N) {
				rear = -1;
			}
			rear++;
			visited[dish[rear]]++;
			if (visited[dish[rear]] > 1)
				checked++;
			
			res = Math.max(res, K + 1 - checked);
		}

		System.out.println(res);
	}
}