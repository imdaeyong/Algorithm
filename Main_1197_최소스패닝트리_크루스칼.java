package house_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//3 3
//1 2 1
//2 3 2
//1 3 3
/**
 * 스캐너썼을때 228120 / 1160ms
 * 버퍼드썼을때 50552 / 500ms
 * @author 김대용
 *
 */
public class Main_1197_최소스패닝트리_크루스칼 {
	static int[] parents;  //내 팀의 번호를 기억할수있는 배열
	static int[] rank;		//효율성을 위해서 사용.	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] edges = new int[E][3];
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				//o1[2]-o2[2] =>오버플로우가 날수도 잇음.
				return Integer.compare(o1[2], o2[2]);
			} 
		});
		
		//각 정점에 대해 유니온파인드 연산준비
		parents = new int[V+1];
		rank = new int[V+1];
		
		for(int i=0; i<V;i++) 
			makeSet(i);
			
		int result = 0;
		int cnt= 0; //간선의 개수!! V-1개까지
		
		for(int i=0; i<E;i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if(a==b) 
				continue; //정점1과 2가 같은팀이라면? 패스
			union(a,b);
			//간선을 선택
			result+=edges[i][2];
			
			//정점의 개수 -1번 반복하면 그만 
			cnt++;
			if(cnt==V-1)
				break;
		}
		System.out.println(result);
		//간선이 연결하는 두 정점이 같은팀이 아니라면 한팀으로 합쳐주고 간선 선택.
		//같은팀이라면 패스
	}
	
	static void makeSet(int x) { //집합을 만드는 함수 ,x에 대해서 내 자신을 집합에 넣음
		parents[x] = x;
	}
	static int findSet(int x) {//x가 누구팀인지 보려면? 
		if(x==parents[x]) //내가 부모라면 내가 팀의 식별자임!
			return x;
		else {			//아니라면 내 부모에 대해 다시 find를 함.
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
		
	}
	static void union(int x, int y) { //두개의 식별자를 받아서 두개의 집합을 하나로 합침.
		int px = findSet(x); //누가 어느팀인지 찾음
		int py = findSet(y); 
		//누가 부모일지를 골라야함. 계층균형을 위해선 더 짧은걸 자식으로 만들어야함.
		if(rank[px] >rank[py]) {//py가 더 짧음.
			parents[py] = px;  //py의 부모가 px가됨. 
		}else {
			parents[px] = py;  //px가 더 짧으면 px의 부모가 py가 됨. 
			if(rank[px] ==rank[py]) { //같은레벨 두개가 뭉치면 레벨이 하나 올라가야함
				rank[py]++; //py의 랭크를 한층 높여줌.
			}
		}
	}
}	
