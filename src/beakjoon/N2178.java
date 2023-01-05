package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class N2178 {
    private static int[][] map;
    private static int[][] graph;
    private static int n;
    private static int m;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        n=Integer.parseInt(stringTokenizer.nextToken());
        m=Integer.parseInt(stringTokenizer.nextToken());

        map=new int[n][m];
        graph=new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j]=Character.getNumericValue(chars[j]);
            }
        }

        bfs(0,0,1);

        System.out.println(graph[n-1][m-1]);
    }

    private static void bfs(int x, int y,int cnt) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(x, y,cnt));
        graph[x][y]=cnt;
        while (!q.isEmpty()){
            Pair p = q.poll();
            x = p.x;
            y = p.y;
            cnt=p.cnt+1;
            for (int i = 0; i <4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=ny && 0<=nx && ny<m && nx<n){
                    if(map[nx][ny]==1 && graph[nx][ny]==0){
                        q.add(new Pair(nx,ny,cnt));
                        graph[nx][ny]=cnt;
                    }
                }
            }
        }
    }

    static class Pair{
        int x;
        int y;
        int cnt;

        public Pair(int x, int y,int cnt) {
            this.x = x;
            this.y = y;
            this.cnt=cnt;
        }
    }
}
