import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_2470_G5_µÎ¿ë¾× {
	static int start = 0;
	static int end;
	static int sum = Integer.MAX_VALUE;
	static int turn = Integer.MAX_VALUE;
	static int before_turn = Integer.MAX_VALUE;
	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = parse(st.nextToken());
		int[] arr = new int[N];
		end = N - 1;
		String[] num = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = parse(num[i]);
		}
		Arrays.sort(arr);
		
		int temp;
		while (start<end) {
			temp = arr[start] + arr[end];
			turn = Math.abs(temp);
			if (turn < sum) {
				sum = turn;
				result[0] = arr[start];
				result[1] = arr[end];
			}
			if (temp > 0)
				end--;
			else
				start++;
			
		}
		System.out.println(result[0] + " " + result[1]);
	}

	private static int parse(String str) {
		return Integer.parseInt(str);
	}
}
