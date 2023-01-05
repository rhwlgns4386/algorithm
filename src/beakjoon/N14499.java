package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14499 {
    public static int[] dx={0,-0,-1,1};
    public static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");

        int[] dice=new int[7];
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());

        int x=Integer.parseInt(stringTokenizer.nextToken());
        int y=Integer.parseInt(stringTokenizer.nextToken());

        int k=Integer.parseInt(stringTokenizer.nextToken());
        
        int[][] map=new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        stringTokenizer=new StringTokenizer(in.readLine()," ");
        for(int i=0;i<k;i++){
            int input=Integer.parseInt(stringTokenizer.nextToken())-1;
            int nx=x+dx[input];
            int ny=y+dy[input];


            if(nx<0||ny<0||nx>=n||ny>=m) continue;

            int tem=dice[1];
            switch (input){
                case 0:
                    dice[1]=dice[4];
                    dice[4]=dice[6];
                    dice[6]=dice[3];
                    dice[3]=tem;
                    break;
                case 1:
                    dice[1]=dice[3];
                    dice[3]=dice[6];
                    dice[6]=dice[4];
                    dice[4]=tem;
                    break;
                case 2:
                    dice[1]=dice[5];
                    dice[5]=dice[6];
                    dice[6]=dice[2];
                    dice[2]=tem;
                    break;
                case 3:
                    dice[1]=dice[2];
                    dice[2]=dice[6];
                    dice[6]=dice[5];
                    dice[5]=tem;
                    break;
            }
            x=nx;
            y=ny;
            if(map[x][y]==0){
                map[x][y]=dice[6];
            }else{
                dice[6]=map[x][y];
                map[x][y]=0;
            }

            System.out.println(dice[1]);
        }
    }
}
