package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14503 {

    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st=new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i< n; i++){
            st=new StringTokenizer(in.readLine());
            for(int j = 0; j< m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(go(r,c,d));
    }

    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    private static int go(int r, int c, int d) {
        int result=0;
        while (true){
            if(map[r][c]==0){
                map[r][c]=2;
                result++;
            }

            boolean isAdvance=false;
            for(int i=1;i<5;i++){
                int nx=r+dx[next(d,-i)];
                int ny=c+dy[next(d,-i)];
                if(!inRange(nx,ny)) continue;

                if(map[nx][ny]==0){
                    r=nx;
                    c=ny;
                    d=next(d,-i);
                    isAdvance=true;
                    break;
                }
            }

            if(!isAdvance){
                int nx=r-dx[d];
                int ny=c-dy[d];
                if(inRange(nx,ny) && map[nx][ny]!=1){
                    r=nx;
                    c=ny;
                }else{
                    break;
                }
            }
        }

        return result;
    }

    private static int next(int d, int alpha) {
        return (d+alpha+4)%4;
    }

    private static boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<m;
    }
}
