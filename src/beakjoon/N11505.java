package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11505 {
    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int N = reader.nextInt();
        int M = reader.nextInt();
        int K = reader.nextInt();

        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = reader.nextInt();
        }

        SegmentTree st = new SegmentTree(A);
        for (int i = 0; i < M + K; i++) {
            int a = reader.nextInt(), b = reader.nextInt(), c = reader.nextInt();

            if (a == 1) {
                st.update_point(b - 1, c);
            } else {
                System.out.println(st.rmq(b - 1, c - 1));
            }
        }
    }

    static class SegmentTree {
        long[] A, st;

        public SegmentTree(long[] a) {
            A = a;
            this.st = new long[a.length * 4];
            build(1, 0, A.length - 1);
        }

        public int left(int p) {
            return p << 1;
        }//p*2와 같다

        public int right(int p) {
            return (p << 1) + 1;
        }

        public void build(int p, int L, int R) {
            if (L == R) {
                st[p] = A[L] % MOD;
                return;
            }
            build(left(p), L, (L + R) / 2);
            build(right(p), (L + R) / 2 + 1, R);

            long p1 = st[left(p)];
            long p2 = st[right(p)];
            st[p] = (p1 * p2) % MOD;
        }

        public long rmq(int p, int L, int R, int i, int j) {
            if (j < L || R < i) return 1;
            if (i <= L && R <= j) return st[p];

            long p1 = rmq(left(p), L, (L + R) / 2, i, j);
            long p2 = rmq(right(p), (L + R) / 2 + 1, R, i, j);

            return (p1 * p2) % MOD;
        }

        public long rmq(int i, int j) {
            return rmq(1, 0, A.length - 1, i, j);
        }

        private long update_point(int p, int L, int R, int idx, int new_value) {
            if (R < idx || idx < L) return st[p];
            if (L == R && L == idx) {
                A[idx] = new_value % MOD;
                return st[p] = A[idx];
            }

            long p1 = update_point(left(p), L, (L + R) / 2, idx, new_value);
            long p2 = update_point(right(p), (L + R) / 2 + 1, R, idx, new_value);
            st[p] =(p1 * p2) % MOD;
            return st[p];

        }

        public long update_point(int idx, int new_value) {
            return update_point(1, 0, A.length - 1, idx, new_value);
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
