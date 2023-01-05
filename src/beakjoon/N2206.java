package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N2206 {
    static class Edge{
        int x;
        int y;
        int z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());
        int[][][] dist=new int[n][m][2];
        int[][] map=new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j]=Character.getNumericValue(chars[j]);
            }
        }

        LinkedList<Edge> q = new LinkedList<>();
        dist[0][0][0]=1;
        q.add(new Edge(0,0,0));
        while (!q.isEmpty()){
            int x=q.peek().x;
            int y=q.peek().y;
            int z=q.peek().z;
            q.remove();

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx&&nx<n &&0<=ny&&ny<m && map[nx][ny]==0 &&dist[nx][ny][z]==0){
                    dist[nx][ny][z]=dist[x][y][z]+1;
                    q.offer(new Edge(nx,ny,z));
                }

                if(z==0 && 0<=nx&& nx<n && 0<=ny && ny<m && map[nx][ny]==1 && dist[nx][ny][z+1]==0){
                    dist[nx][ny][z+1]=dist[x][y][z]+1;
                    q.offer(new Edge(nx,ny,z+1));
                }
            }
        }
        if (dist[n-1][m-1][0] != 0 && dist[n-1][m-1][1] != 0) {
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        } else if (dist[n-1][m-1][0] != 0) {
            System.out.println(dist[n-1][m-1][0]);
        } else if (dist[n-1][m-1][1] != 0) {
            System.out.println(dist[n-1][m-1][1]);
        } else {
            System.out.println(-1);
        }
    }
}
