
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author taehee kim
 *
 */
public class Main_B17143_낚시왕 {

	static class Shark{
		int speed,dir,size;

		public Shark(int speed, int dir, int size) {
			super();
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}
		
		
	}
	
	static int R,C,M,sum,col;
	static Shark[][] map;
	static final int UP=1, DOWN=2, RIGHT=3, LEFT=4;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = col = 0; // col:낚시왕 위치열
		map = new Shark[R][C];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		while(col<C) {
			
			// 가까운 상어 잡기
			take();
			// 상어이동하며 잡아먹기
			move();
			col++;
		}
		
		System.out.println(sum);
		
	}


	private static void move() {

		Shark[][] temp = new Shark[R][C];
		int k = 0, s = 0, a = 0, x, y, d;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				Shark curShark = map[i][j];
				if(curShark == null) continue; // 현자리에 상어가 없다면 다음 칸으로.
				if(curShark.dir == UP || curShark.dir == DOWN) { //위,아래 : 행변화
					k = i;
					s = curShark.speed%(2*(R-1)); //   속도 개선 : 2*(R-1)번 이동하면 제자리
					a = curShark.dir == UP?-1:1;
					
					while(s-->0) {
						if(k+a<0 || k+a>=R) a = -a; // 경계를 벗어나면 방향 턴
						k += a;
					}
					x = k;
					y = j;
					d = a<0 ? UP : DOWN;
					
				}else { // 왼쪽, 오른쪽 : 열변화
					k = j;
					s = curShark.speed%(2*(C-1)); //   속도 개선 : 2*(C-1)번 이동하면 제자리
					a = curShark.dir == LEFT ?-1:1;
					
					while(s-->0) {
						if(k+a<0 || k+a>=C) a = -a; // 경계를 벗어나면 방향 턴
						k += a;
					}
					x = i;
					y = k;
					d = a<0 ? LEFT : RIGHT;
				}
				
				curShark.dir = d;
				// s만큼 이동한 후의 x,y 위치에 다른 상어 있는 지 체크하여 다른상어가 있다면 크기 비교하여 큰상어로 남김.
				if(temp[x][y] != null) {
					if(temp[x][y].size < curShark.size ) {
						temp[x][y] = curShark;
					}
				}else { // 그 위치에 다른상어가 없으면 자기가 그자리에 남기
					temp[x][y] = curShark;
				}
				
			}
			
		}// end for i
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
		
	}


	private static void take() { // 낚시왕의 현위치(땅 기반)에서 가장 가까운 상어 잡기
		for (int i = 0; i < R; i++) {
			if(map[i][col] != null) { // 해당 행에 상어가 있다면
				sum += map[i][col].size;
				map[i][col] = null;
				break;
			}
		}
	}
	
	
	
	
	
	

}


















