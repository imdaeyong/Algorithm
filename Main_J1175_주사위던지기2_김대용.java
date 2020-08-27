package algo_0129_hw;
import java.util.Arrays;
import java.util.Scanner;

public class Main_J1175_주사위던지기2_김대용 {
	static int n; //주사위 던진횟수
	static int m; //주사위 눈의 합
	static int[] nums; //주사위눈금들	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int [n];
		dice(0,0);
		sc.close();
	}

	private static void dice(int index,int sum) {
		if(sum>m) return;
		if(index==n) {
			if(sum==m) {
				for(int i=0; i<n;i++) {
					System.out.print(nums[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		for(int i=1; i<=6;i++) {			
			nums[index]=i;		
			dice(index+1,sum+i);
		}	
//		arr[index]=1;
//		dice(index+1,sum+1);
//		arr[index]=2;
//		dice(index+1,sum+2);
//		arr[index]=3;
//		dice(index+1,sum+3);
	}
}
