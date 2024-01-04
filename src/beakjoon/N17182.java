package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17182 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int startNode = Integer.parseInt(stringTokenizer.nextToken());

        int[][] adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        boolean[] visit = new boolean[N];
        visit[startNode]=true;
        System.out.println(go(adj,visit,startNode,N));
    }

    private static int go(int[][] dist, boolean[] visit, int here, int deeps) {
        if(deeps==1){
            return 0;
        }
        int answer=1000*10+1;
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                answer=Math.min(answer,go(dist, visit, i, deeps - 1)+dist[here][i]);
                visit[i]=false;
            }
        }

        return answer;
    }
}
