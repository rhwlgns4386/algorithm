package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N11437_2 {
    static int[] E,L,H,tree;
    static int idx=0;
    private static ArrayList<ArrayList<Integer>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        H=new int[n+1];
        Arrays.fill(H,-1);
        E=new int[(n+1)*2];
        L=new int[(n+1)*2];
        a = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            a.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            a.get(u).add(v);
            a.get(v).add(u);
        }

        dfs(1,0);

        tree=new int[getNodeCount(idx)];
        init(0,idx-1,1);
        int m=Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            int min=Math.min(H[u],H[v]);
            int max=Math.max(H[u],H[v]);

            sb.append(E[query(0,idx-1,min,max,1)]);//E[rmq(H[start],H[end])]
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int getNodeCount(int idx) {
        int h=(int)Math.ceil(Math.log(idx)/Math.log(2))+1;
        return (int)Math.pow(2,h)-1;
    }

    public static void dfs(int here,int depth){
        H[here]=idx;
        E[idx]=here;
        L[idx++]=depth;

        for(Integer next:a.get(here)){
            if(H[next]==-1){
                dfs(next,depth+1);
                E[idx]=here;
                L[idx++]=depth;
            }
        }
    }

    private static int init(int start, int end, int node) {
        if(start==end){
            return tree[node]=H[E[start]];
        }

        int mid = (start+end)/2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    static int query(int start, int end, int left, int right, int node) {
        if(right < start || end < left) return Integer.MAX_VALUE;
        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start+end) /2;

        return Math.min(query(start, mid, left, right, node*2),
                query(mid+1, end, left, right, node*2+1));
    }
}
