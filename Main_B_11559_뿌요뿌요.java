package study_0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_11559_뿌요뿌요 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String line = in.readLine();
			for (int j = 0; j < 6; j++) {
				map[i] = line.toCharArray();
			}
		}
		int[] dy = {-1,0,1,0};
		int[] dx = {0,1,0,-1};
		for(int i=11;i>=0;i--) {
			for(int j=0; j<6;j++) {
				if(map[i][j]!='.') {
					
				}
			}
		}		
	}
}

