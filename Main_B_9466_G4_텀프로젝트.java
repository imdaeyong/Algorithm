package restart0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_9466_텀프로젝트 {
    private static int T;
    private static int n;
    private static int[] students;
    private static boolean[] isVisit;
    private static boolean[] isCheck;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {        	
            n = Integer.parseInt(in.readLine());

            students = new int[n + 1];
            isVisit = new boolean[n + 1];
            isCheck = new boolean[n + 1];
            count = 0;
            
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 1; i <= n; i++) {
                if (!isCheck[i]) { // 확인된 숫자인지?
                    dfs(i);
                }
            }

            sb.append(n - count);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int now) {
        if (isVisit[now]) { //방문했었던 곳이면 체크하고 count ++
        	isCheck[now] = true;
            count++;
        } else { //방문안했던곳이면 방문체크 후 다음으로 
            isVisit[now] = true;
        }

        int next = students[now]; //student[1]이 3이면 다음으로 student[3]을 수행.

        if (!isCheck[next]) { //다음숫자가 체크했던곳이면 패스
            dfs(next);
        }

        isVisit[now] = false; //방문 했던거 되돌리기
        isCheck[now] = true; //여긴 이제 끝났으니까 안와도됨.
    }
}