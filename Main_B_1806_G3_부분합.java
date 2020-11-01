package restart0827;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1806_G3_부분합 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min_l = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0, end = 0;
        while(true){
            if(sum >= S){
                sum -= arr[start];
                start++;
                min_l = min_l<end-start+1 ? min_l:end-start+1;
            }else if(end == N) break;
            else sum += arr[end++];
        }
        if(min_l > 100001){
            min_l=0;
        } 
        System.out.println(min_l);
    }
}