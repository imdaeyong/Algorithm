package study_4_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main_B_2252_줄세우기 { 
    static int N, M;
    static List<Integer>[] list;
    static Stack<Integer> stack;
    static boolean[] visited, finished;
    static boolean isCycle = false;
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        stack = new Stack<>();
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            list[i] = new ArrayList<Integer>();
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int st1 = Integer.parseInt(st.nextToken());
            int st2 = Integer.parseInt(st.nextToken());
            list[st1].add(st2);
        }
 
        for (int i = 1; i <= N; i++) {
            if (!finished[i])
                dfs(i);
        }
 
        if (!isCycle) {
            while (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }
    }
 
    public static void dfs(int student) {
 
        visited[student] = true;
        for (int i = 0; i < list[student].size(); i++) {
 
            int adj = list[student].get(i);
 
            if (!visited[adj])
                dfs(adj);
            else if (!finished[adj])
                isCycle = true;
        }
        finished[student] = true;
        stack.push(student);
    }
}