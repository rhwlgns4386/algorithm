package beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N4195 {
    private static FastReader in;
    private static OutputStreamWriter out=new OutputStreamWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        in= new FastReader();
        int N = in.nextInt();
        for(int i=0;i<N;i++){
            solution(in.nextInt());
        }

        out.flush();
        out.close();
    }

    private static void solution(int M) throws IOException {
        UnionFind unionFind = new UnionFind(M * 2);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<M;i++){
            String user1=in.next();
            String user2=in.next();

            map.put(user1, map.getOrDefault(user1,map.size()));
            map.put(user2, map.getOrDefault(user2,map.size()));

            unionFind.union(map.get(user1),map.get(user2));

            out.write(unionFind.count(map.get(user1))+"\n");
        }

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

