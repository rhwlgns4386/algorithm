package groom.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N3 {
    public static int[] cnt = new int[1004];
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] a = new ArrayList[n + 1];
        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        bfs(a,n,1);
        System.out.println(cnt[n]<=k&&cnt[n]!=-1?"YES":"NO");
    }

    private static void bfs(ArrayList<Integer>[] a, int end, int start) {
        Arrays.fill(cnt,-1);
        cnt[start]=0;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            Integer p = q.remove();

            for(Integer i:a[p]){
                if(cnt[i]==-1){
                    q.add(i);
                    cnt[i]=cnt[p]+1;
                }
            }
        }
    }
}
