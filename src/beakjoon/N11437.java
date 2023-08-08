package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11437 {
    static int[] E,L,H;
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

        int m=Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            int min=Math.min(H[u],H[v]);
            int max=Math.max(H[u],H[v]);

            sb.append(E[rmq(min,max)]);
            sb.append("\n");
        }

        System.out.println(sb);
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

    public static int rmq(int start,int end){
        if(start==end){
            return start;
        }

        int mid=(start+end)/2;
        int left=rmq(start,mid);
        int right=rmq(mid+1,end);

        if(L[left]<=L[right]) return left;
        return right;
    }
}
