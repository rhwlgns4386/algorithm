package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2468 {

    private static int n;
    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        map = new int[n][n];
        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j< n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int safetyCount=0;
        for(int h=0;h<=100;h++){
            visit = createVisit(h);
            safetyCount=Math.max(safetyCount, countingSafetyJone());
        }

        System.out.println(safetyCount);
    }

    private static int countingSafetyJone() {
        int count=0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                if(!visit[i][j]){
                    count++;
                    fill(i,j);
                }
            }
        }
        return count;
    }

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    private static void fill(int x,int y) {
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(isRange(nx,ny) && !visit[nx][ny]){
                fill(nx,ny);
            }
        }
    }

    private static boolean isRange(int nx, int ny) {
        if(0<=nx && nx<n && 0<=ny && ny<n) return true;
        return false;
    }

    private static boolean[][] createVisit(int h) {
        boolean[][] visit = new boolean[n][n];

        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                if(map[i][j]<=h){
                    visit[i][j]=true;
                }
            }
        }
        return visit;
    }
}
