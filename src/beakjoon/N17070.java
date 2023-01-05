package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17070 {
    public static int[] dx={0,1,1};
    public static int[] dy={1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[][] map=new int[n][n];

        StringTokenizer stringTokenizer;
        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(go(map,0,1, new int[]{0, 2}));
    }

    private static int go(int[][] map, int x, int y,int[] checkList) {
        int cnt=0;
        if(x==map.length-1 && y== map.length-1) return 1;
        for(int option:checkList){
            int nx=x+dx[option];
            int ny=y+dy[option];
            if(0<=nx && 0<=ny && map.length>nx && map.length>ny && map[nx][ny]!=1){
                switch (option){
                    case 0:
                        cnt+=go(map,nx,ny,new int[]{0,2});
                        break;
                    case 1:
                        cnt+=go(map,nx,ny,new int[]{1,2});
                        break;
                    case 2:
                        boolean flag=false;
                        for(int i=0;i<2;i++){
                            int checkX=x+dx[i];
                            int checkY=y+dy[i];
                            if(0>checkX || 0>checkY ||checkX>=map.length || checkY>= map.length || map[checkX][checkY]==1){
                                flag=true;
                            }
                        }
                        if(!flag){
                            cnt+=go(map,nx,ny,new int[]{0,1,2});
                        }
                        break;
                }
            }
        }
        return cnt;
    }
}
