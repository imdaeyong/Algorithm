package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_B_14891_S1_톱니바퀴 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		int[][] gear = new int[4][8];
		for(int i=0; i<4; i++) {
			String str = in.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(in.readLine());
		for(int i=0; i<K; i++) {
			st= new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			int[] d = new int[4];
			d[num] = dir;
			for(int j=num-1; j>=0; j--) {
				if(gear[j][2] != gear[j+1][6]) d[j] = -1*d[j+1]; 
				else break;
			}
			for(int j=num+1; j<4; j++) {
				if(gear[j-1][2] != gear[j][6]) d[j] = -1*d[j-1];
				else break;
			}
			for(int j=0; j<4; j++) {
				int temp = 0;
				if(d[j] == 1) {
					temp = gear[j][7];
					for(int k=7; k>0; k--) {
						gear[j][k] = gear[j][k-1];
					}
					gear[j][0] = temp;
				}
				else if(d[j] == -1){
					temp = gear[j][0];
					for(int k=1; k<8; k++) {
						gear[j][k-1] = gear[j][k];
					}
					gear[j][7] = temp;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<4; i++) {
			if(gear[i][0] == 1) {
				ans |= 1<<i;
			}
		}
		System.out.println(ans);
	}
}
