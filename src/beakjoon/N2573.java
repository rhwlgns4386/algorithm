package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2573 {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[n][m];
        int[][] tem= new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int ans=0;
        while(true){

            if(dfsAll(map,visit)){
                break;
            }

            for(int i=0;i<tem.length;i++){
                Arrays.fill(tem[i],0);
            }

            if(melting(n, m, map, tem)){
                ans=0;
                break;
            }

            ans++;
        }
        System.out.println(ans);
    }

    private static boolean melting(int n, int m, int[][] map, int[][] tem) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0){
                    for(int idx=0;idx<4;idx++){
                        int nx=i+dx[idx];
                        int ny=j+dy[idx];
                        if(0<=nx && nx< n && 0<=ny &&ny< m && map[nx][ny]!=0){
                            tem[nx][ny]-=1;
                        }
                    }
                }
            }
        }

        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]= map[i][j]+tem[i][j];
                if(map[i][j]<0){
                    map[i][j]=0;
                }
                cnt+=map[i][j];
            }
        }

        if(cnt==0){
            return true;
        }
        return false;
    }

    private static boolean dfsAll(int[][] map,boolean[][] visit) {
        for(int i=0;i<visit.length;i++){
            Arrays.fill(visit[i],false);
        }

        int cnt=0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if(!visit[i][j] && map[i][j]!=0){
                    dfs(map,visit,i,j);
                    cnt+=1;
                }

                if(cnt==2){
                    return true;
                }
            }
        }
        return false;
    }

    private static void dfs(int[][] map, boolean[][] visit,int x,int y) {
        if(visit[x][y]) return;
        visit[x][y]=true;
        for(int idx=0;idx<4;idx++){
            int nx=x+dx[idx];
            int ny=y+dy[idx];
            if(0<=nx && nx<map.length && 0<=ny &&ny<map[0].length && map[nx][ny]!=0){
                dfs(map,visit,nx,ny);
            }
        }
    }
}
