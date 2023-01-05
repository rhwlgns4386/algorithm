package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] map=new int[101];
        int[] dist=new int[101];
        for(int i=1;i<=100;i++){
            map[i]=i;
            dist[i]=-1;
        }
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n+m; i++) {
            tokenizer=new StringTokenizer(in.readLine()," ");
            int from=Integer.parseInt(tokenizer.nextToken());
            int to=Integer.parseInt(tokenizer.nextToken());
            map[from]=to;
        }

        dist[1]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            Integer x = q.remove();
            for(int i=1;i<=6;i++){
                int y=x+i;
                if(y>100) continue;
                y=map[y];
                if(dist[y]==-1){
                    dist[y]=dist[x]+1;
                    q.add(y);
                }
            }
        }
        System.out.println(dist[100]);

    }
}
