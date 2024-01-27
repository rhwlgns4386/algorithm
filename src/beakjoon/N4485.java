package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N4485 {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }

        public int compareTo(Node o){
            return Integer.compare(this.cost,o.cost);
        }
    }


    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static final int INF=4500;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cnt=1;
        while (true){
            int n=Integer.parseInt(in.readLine());

            if(n==0)
                break;

            int[][] map = new int[n][n];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j=0;j<n;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(dist[i],INF);
            }

            dist[0][0]=map[0][0];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0,map[0][0]));
            while (!pq.isEmpty()){
                Node node = pq.remove();
                int x=node.x;
                int y=node.y;
                int cost=node.cost;

                if(cost>dist[x][y]) continue;
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];

                    if(0<=nx&&nx<n && 0<=ny && ny<n &&map[nx][ny]+cost<dist[nx][ny]){
                        dist[nx][ny]=map[nx][ny]+cost;
                        pq.add(new Node(nx,ny,dist[nx][ny]));
                    }
                }
            }

            System.out.println("Problem "+cnt+": "+dist[n-1][n-1]);
            cnt++;
        }
    }
}
