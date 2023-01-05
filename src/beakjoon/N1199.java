package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1199 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        int[][] graph=new int[n][n];
        ArrayList<Integer> visitNode=new ArrayList<>();
        boolean check=false;

        for(int i=0;i<n;i++){
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int sum=0;
            for(int j=0;j<n;j++){
                graph[i][j]=Integer.parseInt(tokenizer.nextToken());
                sum+=graph[i][j];
            }
            if(sum%2!=0){
                check=true;
                break;
            }
        }

        if(check){
            System.out.println("-1");
        }else{
            dfs(graph,visitNode,n,0);
            Collections.reverse(visitNode);
            StringBuilder sb=new StringBuilder();
            for (Integer integer : visitNode) {
                sb.append(integer);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }

    private static void dfs(int[][] graph, ArrayList<Integer> visitNode, int n, int start) {
        for(int i=0;i<n;i++){
            if(graph[start][i]>0){
                graph[start][i]--;
                graph[i][start]--;
                dfs(graph,visitNode,n,i);
            }
        }
        visitNode.add(start+1);
    }

}
