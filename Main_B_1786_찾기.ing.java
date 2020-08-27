package house_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_1786_찾기 {
	// 모든 경우를 다 비교하지 않아도 부분 문자열을 찾을수 있는 알고리즘
	// 접두사와 접미사 개념을 활용해서 '반복되는 연산을 최대한 줄이도록'
	// 지금까지 검사한 문자열의 접두사와 접미사가 일치하는 최대길이만큼 겹침을 이용
	
	//파이 테이블 : 각 길이별로 접두사 == 접미사의 최대길이가 저장된 배열
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	static String T;
	
	
	static int[] getPi(String pattern) { //정수배열
		int[] pi = new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length(); i++) {
			//맞는 경우
			if(pattern.charAt(i) == pattern.charAt(j)) {
				//i길이 문자열의 공동길이는 j의 위치 +1
				pi[i] = ++j;				
			}
			//안맞는경우
			else {
				//맞는놈이 올때까지 전칸에서의 공통부분 위치로 이동
				while(j>0 && pattern.charAt(i)!= pattern.charAt(j))
					j =pi[j-1];
			}
		}
		return pi;
	}
	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j=0;
		cnt = 0;
		for(int i=0; i<origin.length(); i++) {
			while(j>0 && origin.charAt(i)!= pattern.charAt(j))
				j =pi[j-1];
			//맞는 경우
			if(origin.charAt(i)==pattern.charAt(j)) {
				if(j==pattern.length()-1) {
					cnt++;
					sb.append(i-pattern.length()+2+" ");
					//다음검색을 위해서
					j=pi[j];
				}
				//맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
				else j++;
			}			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		String P = br.readLine();
		KMP(T,P);
		System.out.println(cnt);
		System.out.println(sb.toString());
		
	}
}
