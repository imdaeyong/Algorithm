package com.ssafy.subset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1931_회의실배정 {
	static class Meeting implements Comparable<Meeting> { // 어차피 comparable구현해야되니까 그냥 만들자
		int start, end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			int result =this.end - o.end; //양수나 음수가 섞이지 않으면 이거 써도됨 그냥!
			if(result==0) { //반례 (1,2)(3,3)(2,3) 2개/3개
				result = this.start- o.start; //종료시간이 같으면 시작시간이 빠른순으로..
			}
			return result;
		}
	}

	static int N;
	static Meeting[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new Meeting[N];
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			list[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}
		Arrays.sort(list);
		ArrayList<Meeting> schedule = new ArrayList<Meeting>();
		schedule.add(list[0]); //첫번쨰꺼 무조건 넣을거임, 제일 종료시간 빠르니깐
		for(int i=1; i<N; i++) { //두번째회의부터 확인.
			if(schedule.get(schedule.size()-1).end <=list[i].start) {
				//배정된 제일 끝회의를 가져와서 현재 리스트의 스타트와 비교!
				schedule.add(list[i]);
			}
		}
		System.out.println(schedule.size());
	}
}
