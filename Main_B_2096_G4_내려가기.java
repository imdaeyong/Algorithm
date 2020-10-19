import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2096_G4_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][3];
		int max[][] = new int[N][3];
		int min[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<3;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<3; i++) 
			max[0][i]=min[0][i]=map[0][i];
		for(int i=1; i<N;i++) {
			max[i][0] = map[i][0] + Math.max(max[i-1][0],max[i-1][1]);
			max[i][1] = map[i][1] + Math.max(max[i-1][1],Math.max(max[i-1][0],max[i-1][2]));
			max[i][2] = map[i][2] + Math.max(max[i-1][1],max[i-1][2]);

			min[i][0] = map[i][0] + Math.min(min[i-1][0],min[i-1][1]);
			min[i][1] = map[i][1] + Math.min(min[i-1][1],Math.min(min[i-1][0],min[i-1][2]));
			min[i][2] = map[i][2] + Math.min(min[i-1][1],min[i-1][2]);
		}

//		for(int i=0; i<3; i++) {
//			System.out.println(max[i][0]);
//			System.out.println(max[i][1]);
//			System.out.println(max[i][2]);
//		}

		int total_max = 0;
		int total_min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			total_max = total_max > max[N-1][i]? total_max:max[N-1][i];
			total_min = total_min < min[N-1][i]? total_min:min[N-1][i];
	 	}
		
		System.out.println(total_max +" " +total_min);
	}
}
