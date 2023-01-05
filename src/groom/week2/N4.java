package groom.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4 {
    static final int[] dx={0,0,0,-1,1};
    static final int[] dy={0,-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[][] map=new int[n][n];

        int k=Integer.parseInt(st.nextToken());

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken())-1;
            int y=Integer.parseInt(st.nextToken())-1;
            for(int j=0;j<5;j++){
                int nx=x+dx[j];
                int ny=y+dy[j];
                if(0<=nx&&nx<n&&0<=ny&&ny<n){
                    map[nx][ny]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                map[i][j]+=map[i][j-1];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                map[j][i]+=map[j-1][i];
            }
        }

        System.out.println(map[n-1][n-1]);
    }
}
