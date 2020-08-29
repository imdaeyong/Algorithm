package restart0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1043_G5_거짓말 {
	static int N, M, facts, cnt;
	static ArrayList<Integer> fact;
	static ArrayList<Integer> party[];
	static ArrayList<Integer> people[];
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		facts = Integer.parseInt(st.nextToken());
		fact = new ArrayList<>();

		party = new ArrayList[M + 1];
		visit = new boolean[M + 1];
		for (int i = 0; i < M + 1; i++) {
			party[i] = new ArrayList<>();
		}

		people = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			people[i] = new ArrayList<>();
		}

		for (int i = 0; i < facts; i++)
			fact.add(Integer.parseInt(st.nextToken()));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int k = Integer.parseInt(st.nextToken());
				party[i].add(k);
				people[k].add(i);
			}
		}

		bfs();

		System.out.println(cnt);

	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < fact.size(); i++) {
			ArrayList<Integer> facter = people[fact.get(i)];

			for (int j = 0; j < facter.size(); j++) {
				if (!visit[facter.get(j)]) {
					visit[facter.get(j)] = true;
					q.add(facter.get(j));
				}
			}
		}

		while (!q.isEmpty()) {
			int p = q.poll();
			for (int i = 0; i < party[p].size(); i++) {
				ArrayList<Integer> danger = people[party[p].get(i)];
				for (int j = 0; j < danger.size(); j++) {
					if (!visit[danger.get(j)]) {
						visit[danger.get(j)] = true;
						q.add(danger.get(j));
					}
				}
			}
		}
		for (int i = 0; i < M; i++)
			if (!visit[i])
				cnt++;
	}
}
