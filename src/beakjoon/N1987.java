package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1987 {
    public static final int[] dx={-1,1,0,0};
    public static final int[] dy={0,0,-1,1};
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visit=new boolean[26];
        StringTokenizer stringTokenizer=new StringTokenizer(in.readLine()," ");
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        char[][] map=new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i]=in.readLine().toCharArray();
        }
        visit[map[0][0]-'A']=true;
        System.out.println(go(map,visit,0,0));
    }

    public static int go(char[][] map,boolean[] visit,int x,int y){
        int ans=0;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx && 0<=ny && nx<r && ny<c && !visit[map[nx][ny]-'A']){
                visit[map[nx][ny]-'A']=true;
                ans=Math.max(go(map,visit,nx,ny),ans);
                visit[map[nx][ny]-'A']=false;
            }
        }
        return ans+1;
    }
}
