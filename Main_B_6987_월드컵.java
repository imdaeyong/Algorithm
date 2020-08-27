package study_4_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_6987_월드컵 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<4;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result=0;
			int win = 0;
			int draw = 0;
			int lose = 0;
			int[] wins = new int[6];
			int[] draws = new int[6];
			int[] loses = new int[6];
			int drawcnt=0;
			for(int i=0;i<6;i++) {
				wins[i]=Integer.parseInt(st.nextToken());
				draws[i]=Integer.parseInt(st.nextToken());
				loses[i]=Integer.parseInt(st.nextToken());
				win+=wins[i];
				draw+=draws[i];
				lose+=loses[i];
				if(draws[i]!=0) drawcnt++;
				
				if(draw%2!=0) result=0;			
				else if(wins[i]+draws[i]+loses[i]!=5) result=0;
				else if(win!=lose) result=0;
				else if(win+draw/2!=15) result=0;				
				else result=1;
			}
			if(drawcnt%2!=0) result=0;
			for(int i=0; i<5;i++) {
				if(draws[i]!=0) {
					for(int j=i+1;j<6;j++) {
						if(draws[j]!=0) {
							while(draws[i]>0 && draws[j]>0) {
								draws[i]--;
								draws[j]--;
							}
							
						}
					}
				}					
			}
			for(int i=0; i<6;i++) {
				for(int j=0; j<6;j++) {
					if(i==j&&i!=5&&j!=5) continue;									
					else if(wins[i]==0)continue;
					else if(loses[j]==0)continue;
					else{
						while(wins[i]>0 && loses[j]>0) {
							wins[i]--;
							loses[j]--;
						}
					}
				}
			}
//			for(int i=0; i<6;i++) {
//					System.out.print(wins[i]+" ");
//					System.out.print(draws[i]+" ");
//					System.out.print(loses[i]);
//					System.out.println();
//			}
			for(int i=0; i<6;i++) {
				if(draws[i]!=0) result=0;
				if(wins[i]!=0) result=0;
				if(loses[i]!=0) result=0;
			}
			System.out.print(result+" ");
		}
	}
}
