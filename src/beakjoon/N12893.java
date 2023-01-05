package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N12893 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer>[] a = new ArrayList[n + 1];
        int[] color=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            stringTokenizer = new StringTokenizer(in.readLine());
            int A=Integer.parseInt(stringTokenizer.nextToken());
            int B=Integer.parseInt(stringTokenizer.nextToken());
            a[A].add(B);
            a[B].add(A);
        }

        for(int i=1;i<=n;i++){
            if(color[i]==0){
                dfs(a,color,i,1);
            }
        }

        int ans=1;

        for(int i=1;i<=n;i++){
            for(Integer j:a[i]){
                if(color[j]==color[i]){
                    ans=0;
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(ArrayList<Integer>[] a, int[] color, int node, int c) {
        color[node]=c;
        for(Integer i:a[node]){
            if(color[i]==0){
                dfs(a,color,i,3-c);
            }
        }
    }
}
