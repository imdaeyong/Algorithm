package restart0827;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_B_1726_G4_로봇 {
    static int dx[] = {0,1,-1,0,0};
    static int dy[] = {0,0,0,1,-1};
    static int M,N;
    static int arr[][];
    static boolean visit[][][];
    static Po start, end;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //직사각형의 세로 길이 M과 가로 길이 N
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[101][101];
        visit = new boolean[101][101][5];
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) {
                arr[m][n] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        int dir = Integer.parseInt(st.nextToken());
        
        start = new Po(x,y,dir,0);
        
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken())-1;
        x = Integer.parseInt(st.nextToken())-1;
        dir = Integer.parseInt(st.nextToken());
        
        end = new Po(x,y,dir,0);
        
        bfs();
        System.out.println(result);
    }
    
    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<Po> queue = new LinkedList<>();
        visit[start.y][start.x][start.dir] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            Po p = queue.poll();
//            System.out.println(p.y+" "+p.x+" "+p.dir+" "+p.cnt);
            if(p.y == end.y && p.x == end.x && p.dir == end.dir) {
                result = p.cnt;
                return;
            }
            
            //명령 1. Go k - k는 1, 2 또는 3일 수 있다. 현재 향하고 있는 방향으로 k칸 만큼 움직인다.
            for(int k=1; k<=3; k++) {
                int newY = p.y + dy[p.dir]*k;
                int newX = p.x + dx[p.dir]*k;
                
                if(0<=newY && newY<M && 0<=newX && newX<N && arr[newY][newX]==0) {
                    if(visit[newY][newX][p.dir])
                        continue;
                    visit[newY][newX][p.dir] = true;
                    queue.add(new Po(newX, newY, p.dir, p.cnt+1));
                }else {
                    break;
                }
            }
            //명령 2. Turn dir - dir은 left 또는 right 이며, 각각 왼쪽 또는 오른쪽으로 90° 회전한다.
            for(int d=1; d<=4; d++) {
                if(p.dir != d && !visit[p.y][p.x][d]) {
                    visit[p.y][p.x][d] = true;
                    //방향은 동쪽이 1, 서쪽이 2, 남쪽이 3, 북쪽이 4
                    if((p.dir==1 && d==2) || (p.dir==2 && d==1) || (p.dir==3 && d==4) || (p.dir==4 && d==3)) {
                        queue.add(new Po(p.x, p.y, d, p.cnt+2));
                    }else
                        queue.add(new Po(p.x, p.y, d, p.cnt+1));
                }
            }
            
        }
    }
 
    public static class Po{
        int x;
        int y;
        int dir;
        int cnt;
        public Po(int x,int y,int dir, int cnt) {
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.cnt=cnt;
        }
    }
}
 