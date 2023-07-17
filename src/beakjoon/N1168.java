package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1168 {

    public static void main(String[] args) {
        Reader in = new Reader();
        int N=in.nextInt();
        int[] A = new int[N + 1];
        SegmentTree st = new SegmentTree(A);
        for(int i=1;i<A.length;i++){
            st.update(i);
        }

        int K=in.nextInt();
        int rmq=st.rmq(K);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<A.length;i++){
           sb.append(rmq+"\n");
           st.remove(rmq);
           rmq=st.rmq((K+rmq)%N);
        }
    }

    private static class SegmentTree {
        private int[] A, st;
        private int n;

        public SegmentTree(int[] a) {
            A = a;
            n = A.length;
            this.st = new int[n * 4];
        }

        public void update(int X) {
            update(1, 1, n - 1, X, 1);
        }

        private void remove(int X) {
            update(1, 1, n - 1, X, -1);
        }

        private int update(int p, int L, int R, int idx, int val) {
            if (idx < L || R < idx) return st[p];
            if (L == idx && R == idx) {
                A[idx] += val;
                st[p] += val;
                if (A[idx] < 0) {
                    A[idx] = 0;
                    st[p] = 0;
                }
                return st[p];
            }

            int mid = (L + R) / 2;
            int p1 = update(left(p), L, mid, idx, val);
            int p2 = update(right(p), mid + 1, R, idx, val);

            return st[p] = p1 + p2;
        }

        public int rmq(int x) {
            return rmq(1, 1, n - 1, x);
        }

        private int rmq(int p, int L, int R, int x) {
            if (L == R) {
                return L;
            }

            int mid = (L + R) / 2;
            if (x > st[left(p)]) {
                return rmq(right(p), mid + 1, R, x - st[left(p)]);
            } else {
                return rmq(left(p), L, mid, x);
            }
        }

        private int left(int p) {
            return p << 1;
        }

        private int right(int p) {
            return (p << 1) + 1;
        }
    }

    //출처 : https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/amp/
    static class Reader {

        BufferedReader br;

        StringTokenizer st;


        public Reader() {

            br = new BufferedReader(

                    new InputStreamReader(System.in));

        }


        String next() {

            while (st == null || !st.hasMoreElements()) {

                try {

                    st = new StringTokenizer(br.readLine());

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            return st.nextToken();

        }


        int nextInt() {
            return Integer.parseInt(next());
        }


        long nextLong() {
            return Long.parseLong(next());
        }


        double nextDouble() {

            return Double.parseDouble(next());

        }


        String nextLine() {

            String str = "";

            try {

                if (st.hasMoreTokens()) {

                    str = st.nextToken("\n");

                } else {

                    str = br.readLine();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

            return str;

        }
    }
}
