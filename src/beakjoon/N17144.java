package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N17144 {
    private static int[] dx={0,-1,0,1};
    private static int[] dy={1,0,-1,0};
    private static int[][] map;
    private static int r=0;
    private static int c=0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        r=Integer.parseInt(stringTokenizer.nextToken());
        c=Integer.parseInt(stringTokenizer.nextToken());
        int t=Integer.parseInt(stringTokenizer.nextToken());
        map=new int[r][c];
        int[][] backup=new int[r][c];

        int x=0;
        int y=0;
        for (int i = 0; i < r; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < c; j++) {
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                if(map[i][j]==-1){
                    x=i;
                }
            }
        }

        x-=1;

        for (int k = 0; k < t; k++) {

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(map[i][j]!=0 &&map[i][j]!=-1){
                        int tem=map[i][j]/5;
                        int count=0;
                        for (int l = 0; l < 4; l++) {
                            int nx=i+dx[l];
                            int ny=j+dy[l];
                            if(0<=nx && 0<=ny && nx<r && ny<c && map[nx][ny]!=-1){
                                backup[nx][ny]+=tem;
                                count+=1;
                            }
                        }
                        map[i][j]=map[i][j]-(tem*count);
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(map[i][j]!=-1){
                        map[i][j]+=backup[i][j];
                        backup[i][j]=0;
                    }
                }
            }

            cycle(x,y, new int[]{0, 1, 2, 3});
            cycle(x+1,y, new int[]{0, 3, 2, 1});
        }

        int ans = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (map[i][j] >= 0) {
                    ans += map[i][j];
                }
            }
        }
        System.out.println(ans);
    }

    private static void cycle(int x, int y, int[] ints) {
        int count=0;
        int index=ints[count];
        int prev=0;
        y+=1;
        while(true){
            int tem=prev;
            if(map[x][y]==-1){
                break;
            }
            prev=map[x][y];
            map[x][y]=tem;

            x+=dx[index];
            y+=dy[index];
            if(x<0 || y<0  ||  x>=r  ||  y>=c){
                x-=dx[index];
                y-=dy[index];
                count+=1;
                index=ints[count];
                x+=dx[index];
                y+=dy[index];
            }
        }
    }
}
