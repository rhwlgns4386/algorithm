package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N10026 {
    public static final int[] dx={-1,1,0,0};
    public static final int[] dy={0,0,-1,1};
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());
        char[][] normal=new char[n][n];
        char[][] weakness=new char[n][n];
        boolean[][] visit=new boolean[n][n];

        for(int i=0;i<n;i++){
            normal[i]=in.readLine().toCharArray();
            for(int j=0;j<n;j++){
                if(normal[i][j]=='R'){
                    weakness[i][j]='G';
                }
                else {
                    weakness[i][j]=normal[i][j];
                }
            }
        }
        int cnt=0;
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(!visit[i][j]){
                    dfs(normal,visit,normal[i][j],i,j);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+" ");

        cnt=0;
        visit=new boolean[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(!visit[i][j]){
                    dfs(weakness,visit,weakness[i][j],i,j);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+" ");
    }

    public static void dfs(char[][] map,boolean[][] visit,char nodeChar,int x,int y){
        if(visit[x][y]) return;
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx && 0<=ny && nx<n &&ny<n){
                if(map[nx][ny]==nodeChar)  dfs(map,visit,nodeChar,nx,ny);

            }
        }
    }
}
