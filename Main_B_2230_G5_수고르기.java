package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_2230_G5_수고르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[] = new int[N];
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(map);
		int start =0;
		int end = 1;
		int ans = Integer.MAX_VALUE;
		while(end<N) {
			int temp = map[end]-map[start];
			if(temp==M) {
				ans = M;
				break;
			}
			if(temp<M) {
				end++;
				continue;
			}
			ans = Math.min(ans, temp);
			start++;
		}
		System.out.println(ans);
	}
}
