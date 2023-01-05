package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1939 {
    static class Pair{
        int to;
        int cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<Pair>[] a = new ArrayList[10001];
    static boolean[] check = new boolean[10001];
    static int n, m, start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            a[from].add(new Pair(to,cost));
            a[to].add(new Pair(from,cost));
        }

        st=new StringTokenizer(in.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left=1;
        int right=1000000000;
        int ans=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            Arrays.fill(check,false);
            if(dfs(start,mid)){
                ans=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int node, int limit) {
        if(check[node])return false;

        check[node]=true;

        if(node==end) return true;

        for(Pair p:a[node]){
            int next=p.to;
            int cost=p.cost;
            if(cost>=limit){
                if(dfs(next,limit)){
                    return true;
                }
            }
        }
        return false;
    }
}
