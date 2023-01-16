package beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        UnionFind unionFind = new UnionFind(N + 1);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<M;i++){
            String[] input = in.readLine().split(" ");
            if(input[0].equals("0")){
                unionFind.union(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
            }else{
                if(unionFind.isSame(Integer.parseInt(input[1]),Integer.parseInt(input[2]))){
                    out.write("YES\n");
                }else{
                    out.write("NO\n");
                }
            }
        }

        out.flush();
        out.close();
        in.close();
    }

    private static class UnionFind {

        private final int[] rank;
        private final int[] p;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i=0;i<n;i++){
                p[i]=i;
            }
        }

        public boolean isSame(int i, int j) {
            return find(i)==find(j);
        }

        private int find(int i) {
            return i==p[i]?i:find(p[i]);
        }

        public void union(int i, int j) {
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
