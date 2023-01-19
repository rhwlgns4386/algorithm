package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        UnionFind unionFind = new UnionFind(N);
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int k=Integer.parseInt(st.nextToken());
                if(k==1){
                    unionFind.union(i,j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstResult= Integer.parseInt(st.nextToken())-1;
        String result="YES";
        for(int i=0;i<M-1;i++){
            if(!unionFind.isSame(firstResult,Integer.parseInt(st.nextToken())-1)){
                result="NO";
            }
        }
        System.out.println(result);
    }

    private static class UnionFind {
        private int[] p,rank;
        public UnionFind(int n) {
            rank=new int[n];
            p=new int[n];
            for(int i=0;i<n;i++){
                p[i]=i;
            }
        }

        boolean isSame(int i,int j){
            return find(i)==find(j);
        }

        private int find(int i) {
            return p[i]==i?i:find(p[i]);
        }

        private void union(int i,int j){
            if(!isSame(i,j)){
                int x=find(i),y=find(j);
                if(rank[x]>rank[y])p[y]=x;
                else{
                    p[x]=y;
                    if(rank[x]==rank[y])rank[y]++;
                }
            }
        }
    }
}
