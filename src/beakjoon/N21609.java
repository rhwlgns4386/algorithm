package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N21609 {

    static class Pair implements Comparable<Pair>{

        int x;
        int y;
        int blockCount;
        int rainbowCount;

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", blockCount=" + blockCount +
                    ", rainbowCount=" + rainbowCount +
                    '}';
        }

        public Pair(int x, int y, int blockCount, int rainbowCount) {
            this.x = x;
            this.y = y;
            this.blockCount = blockCount;
            this.rainbowCount = rainbowCount;
        }

        @Override
        public int compareTo(Pair o) {
            int compare = -Integer.compare(this.blockCount, o.blockCount);
            if(compare==0){
                compare=-Integer.compare(this.rainbowCount,o.rainbowCount);

                if(compare==0){
                    compare=-Integer.compare(this.x,o.x);
                    if(compare==0){
                        compare=-Integer.compare(this.y,o.y);
                    }
                }
            }

            return compare;
        }
    }

    private static int n;
    private static int m;
    private static int[][] map;


    static int EMPTY_BLOCK =-2;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int result=0;
        while (true){
            int[][] visit = new int[n][n];
            int groupCount=1;
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]>0 && visit[i][j]==0){
                        Pair pair = bfs(groupCount, visit, i, j);
                        groupCount++;
                        if(pair.blockCount>1){
                            pq.add(pair);
                        }
                    }
                }
            }

            if(pq.size() ==0){
                break;
            }
            Pair pair = pq.remove();
            remove(pair);
            result+=pair.blockCount*pair.blockCount;

            gravity();

            rotate();

            gravity();

        }
        System.out.println(result);
    }

    private static void printMap() {
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    private static void rotate() {
        int[][] tem=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tem[n-1-j][i]=map[i][j];
            }
        }

        map=tem;
    }

    private static void gravity() {

        for(int i=n-1;0<=i;i--){
            for(int j=0;j<n;j++){
                if(map[i][j]>=0){
                    int nx=i+1;
                    while (true){
                        if(!inRange(nx,j)){
                            if(nx-1==i) break;
                            map[nx-1][j]=map[i][j];
                            map[i][j]=EMPTY_BLOCK;
                            break;
                        }
                        if(map[nx][j]!=EMPTY_BLOCK){
                            if(nx-1==i) break;
                            map[nx-1][j]=map[i][j];
                            map[i][j]=EMPTY_BLOCK;
                            break;
                        }
                        nx+=1;
                    }
                }else{
                    map[i][j]=map[i][j];
                }
            }
        }
    }

    private static void remove(Pair start) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{start.x, start.y});
        int findNumber = map[start.x][start.y];

        boolean[][] visit = new boolean[n][n];
        visit[start.x][start.y]=true;
        while (!q.isEmpty()){
            int[] node = q.remove();
            int x=node[0];
            int y=node[1];


            map[x][y]=EMPTY_BLOCK;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(!inRange(nx,ny)) continue;

                if((map[nx][ny]==findNumber||map[nx][ny]==0) && !visit[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visit[nx][ny]=true;
                }
            }
        }
    }

    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    private static Pair bfs(int groupCount, int[][] visit, int startx, int starty) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{startx,starty});
        visit[startx][starty]=groupCount;


        int blockCount=0;
        int rainbowCount=0;
        while (!q.isEmpty()){
            int[] node = q.remove();
            int x=node[0];
            int y=node[1];

            blockCount++;
            if(map[x][y]==0){
                rainbowCount++;
            }

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(!inRange(nx,ny)) continue;

                if((map[nx][ny]==map[startx][starty]||map[nx][ny]==0) && visit[nx][ny]!=groupCount){
                    visit[nx][ny]=groupCount;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return new Pair(startx,starty,blockCount,rainbowCount);
    }

    private static boolean inRange(int x, int y) {
        if(0<=x && x<n && 0<=y && y<n) return true;
        return false;
    }
}
