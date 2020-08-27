package study_4_4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main_B_2363_치즈 {
 
    static int x,y;
    static int map[][];
    static int visit[][];
    static int result;
    static int dy[] = {0,1,0,-1};
    static int dx[]= {-1,0,1,0};
    static Queue<pos> q;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x= sc.nextInt();
        y= sc.nextInt();
        map= new int[x][y];
        visit = new int[x][y];
        q = new LinkedList<>();
        
        int count=0;        
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]==1) {
                    count++;
                }
            }
        }
        
        boolean cheese = true;
        result = 0;
        int min=count;
        while(cheese) {
            q.add(new pos(0,0));
            visit[0][0]=1;
            for(int i=0;i<x;i++) {
                for(int j=0;j<y;j++) {
                    visit[i][j]=0;
                }
            }
            
            BFS();
         
            int cnt=0;
            cheese= false;
            for(int i=0;i<x;i++) {
                for(int j=0;j<y;j++) {
                    if(map[i][j]==1) {
                        cnt++;
                    }
                }
            }
            
            if(cnt!=0) {
                min=cnt;
                cheese=true;
            }
            if(cnt==0) {
                break;
            }
        }
        System.out.println(result);
        System.out.println(min);
    }
 
    private static void BFS() {
        result++;
        while(!q.isEmpty()) {
            pos temp = q.poll();
            for(int i=0;i<4;i++) {
            	int ny = temp.y+dy[i];
                int nx = temp.x+dx[i];
                if(nx<0||ny<0||nx>=x||ny>=y) {
                    continue;
                }
                if(map[nx][ny]==0&&visit[nx][ny]==0) {
                    visit[nx][ny]=1;
                    q.add(new pos(nx,ny));
                }if(map[nx][ny]==1) {
                    visit[nx][ny]++;
                    if(visit[nx][ny]>=1) {
                        map[nx][ny]=0;  
                    }
                }
            }
        }
    }
    private static class pos{
        int x, y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}