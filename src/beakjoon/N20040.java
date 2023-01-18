package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N20040 {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int N = in.nextInt();
        int M = in.nextInt();

        UnionFind unionFind = new UnionFind(N);

        for(int i=1;i<M+1;i++){
            int start=in.nextInt();
            int end=in.nextInt();

            if(unionFind.isSame(start,end)){
                System.out.println(i);
                return;
            }

            unionFind.union(start,end);
        }

        System.out.println("0");
    }

    private static class UnionFind {

        private final int[] p;
        private final int[] rank;

        public UnionFind(int m) {
            rank = new int[m];
            Arrays.fill(rank,1);

            p = new int[m];
            for(int i=0;i<m;i++){
                p[i]=i;
            }
        }

        public boolean isSame(Integer i,Integer j){
            return find(i)== find(j);
        }

        public int find(Integer i) {
            return i==p[i]?i:find(p[i]);
        }

        public void union(Integer i, Integer j) {
            if(!isSame(i,j)){
                int x=find(i),y=find(j);
                if(rank[x]>rank[y]){
                    p[y]=x;
                    rank[x]+=rank[y];
                }else{
                    p[x]=y;
                    rank[y]+=rank[x];
                }
            }
        }

        public int count(Integer i) {
            int x = find(i);
            return rank[x];
        }
    }
    static class FastReader {


        BufferedReader br;

        StringTokenizer st;


        public FastReader() {

            br = new BufferedReader(new InputStreamReader(System.in));

        }


        String next() throws IOException {

            while (st == null || !st.hasMoreElements()) {

                st = new StringTokenizer(br.readLine());
            }

            return st.nextToken();

        }


        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }


        long nextLong() throws IOException {
            return Long.parseLong(next());
        }


        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        String nextLine() throws IOException {

            String str = "";


            if (st.hasMoreTokens()) {

                str = st.nextToken("\n");

            } else {

                str = br.readLine();

            }
            return str;
        }

    }
}
