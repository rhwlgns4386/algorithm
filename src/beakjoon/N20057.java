package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N20057 {

    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[][] map=new int[n][n];
        rotateRatioMap();
        rotateRatioMap();
        rotateRatioMap();
        for(int i=0;i<n;i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int x=n/2;
        int y=n/2;
        for(int i=0;i<n*n;i++){
            int[] position = nextPosition(x, y);
            x=position[0];
            y=position[1];
            calcMoveDust(map,x,y);
        }

        System.out.println(result);
    }

    static float[][] ratioMap={{0,0,0.02f,0,0},{0,0.1f,0.07f,0.01f,0},{0.05f,-1,0,0,0},{0,0.1f,0.07f,0.01f,0},{0,0,0.02f,0,0}};
    static int len=0;
    static int moveCount=0;
    static int idx=-1;
    public static int[] nextPosition(int x,int y){
        moveCount++;
        if(moveCount>=len){
            idx=(idx+1)%dx.length;
            rotateRatioMap();
            moveCount=0;
            if(idx==2 || idx==0){
                len++;
            }
        }

        return new int[]{x+dx[idx],y+dy[idx]};
    }

    public static void calcMoveDust(int[][] map,int x,int y){
        if(!inRange(map,x,y)){
            return;
        }
        int hereDust=map[x][y];
        int alpaX=-1;
        int alpaY=-1;
        for(int i=-2;i<=2;i++){
            for(int j=-2;j<=2;j++){
                if(ratioMap[i+2][j+2]==-1){
                    if(inRange(map,x+i,y+j)){
                        alpaX=x+i;
                        alpaY=y+j;
                    }
                }else {
                    int increateNumber = (int) (map[x][y] * ratioMap[i + 2][j + 2]);
                    if(inRange(map,x+i,y+j)){
                        map[x+i][y+j]+=increateNumber;
                    }else{
                        result+=increateNumber;
                    }
                    hereDust-=increateNumber;
                }
            }
        }

        if(alpaX==-1 && alpaY==-1){
            result+=hereDust;
        }else{
            map[alpaX][alpaY]+=hereDust;
        }
        map[x][y]=0;
    }

    private static boolean inRange(int[][] map, int x, int y) {
        return 0<=x&& x<map.length && 0<=y && y<map[0].length;
    }

    public static void rotateRatioMap(){
        float[][] map=new float[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[4-j][i]=ratioMap[i][j];
            }
        }
        ratioMap=map;
    }
}
