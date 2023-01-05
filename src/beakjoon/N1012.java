package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1012 {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while (T-->0){
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
            int M=Integer.parseInt(stringTokenizer.nextToken());
            int N=Integer.parseInt(stringTokenizer.nextToken());
            int K=Integer.parseInt(stringTokenizer.nextToken());
            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            for(int i=0;i<K;i++){
                stringTokenizer=new StringTokenizer(in.readLine());
                int y=Integer.parseInt(stringTokenizer.nextToken());
                int x=Integer.parseInt(stringTokenizer.nextToken());
                map[x][y]=1;
            }

            int cnt=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1 && !visit[i][j]){
                        dfs(i,j,map,visit);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int x,int y,int[][] map, boolean[][] visit) {
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || map.length<=nx || ny<0 || map[0].length<=ny || map[nx][ny]==0 ||visit[nx][ny]) continue;
            dfs(nx,ny,map,visit);
        }
    }
}
