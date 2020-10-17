package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B__15565_S1_귀여운라이언 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		String arr[] = new String[N];
		int start = -1;
		for(int i=0; i<N; i++) {
			arr[i] = st.nextToken();
//			if(arr[i].equals("1")) {
//				start = i;
//			}
		}
		int min_size = Integer.MAX_VALUE;
		int rions = 0;
		int size = 0;
		for (int i = 0; i < N; i++) {
			if(start>=0) size++;
			if (arr[i].equals("1")) {
				if (start == -1) {
					start = i;
					size++;
				}
				rions++;
				if (rions == K) {
					min_size = min_size<size? min_size:size;
					while (start < i) {
						size--;
						start++;
						if (arr[start].equals("1"))
							break;
					}
					rions--;
				}
			}
		}
		if(min_size ==Integer.MAX_VALUE) min_size =-1;
		System.out.println(min_size);
	}

}
