import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int endx=3;
    static int endy=3;
    public static void main(String[] args) {
        System.out.println(bfs(0,0,new boolean[endx][endy]));
    }

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    private static int bfs(int startx, int starty, boolean[][] visit) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{startx,starty});

        int count=0;
        while (!q.isEmpty()){
            int[] node = q.remove();
            int x=node[0];
            int y=node[1];

            if(x==endx-1 && y==endy-1){
                count++;
                continue;
            }

            visit[x][y]=true;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(isRange(nx,ny) && !visit[nx][ny]){
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return count;
    }


    private static int dfs(int x, int y, boolean[][] visit) {
        if(x==endx-1 && y==endy-1){
            return 1;
        }

        visit[x][y]=true;

        int count=0;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(isRange(nx,ny) && !visit[nx][ny]){
                count+=dfs(nx,ny,visit);
            }
        }
        visit[x][y]=false;

        return count;
    }

    private static boolean isRange(int nx, int ny) {
        return 0<=nx && 0<=ny && nx<endx && ny<endy;
    }
}
