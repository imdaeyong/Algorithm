

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 전개되는 형태를 보면 피보나치 수열
// i열까지 타일 채우는 경우의수  : 세로 아래타일(1*1)로 i열을 만드는 경우의 수 + 가로타일(2*1,2*2)로 i열을 만드는 경우의 수 
// 세로 아래타일로 i열을 만드는 경우의 수(자신이 2개행1개열 차지): i-1열까지 타일을 채우는 경우의 수
// 가로타일(2*1)로 i열을 만드는 경우의 수(자신이 1개행2개열 차지)==>타일2개사용 : i-2열까지 타일을 채우는 경우의 수
// 가로타일(2*2)로 i행을 만드는 경우의 수(자신이 2개행2개열 차지): i-2열까지 타일을 채우는 경우의 수

/**
 * 
 * @author taeheekim
 *
 */
public class Main11727_2xn타일링2_0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] D = new int[N+1];
		
		D[0]=D[1]=1; 
		for (int i = 2; i <= N; ++i) D[i] = ((2*D[i-2])%10007+D[i-1])%10007;
		System.out.println(D[N]);		
	}

}