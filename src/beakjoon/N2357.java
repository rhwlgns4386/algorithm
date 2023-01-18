package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class N2357 {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int N=in.nextInt();
        int M=in.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=in.nextInt();
        }

        SegmentTree minSegmentTree = new SegmentTree(A, SegmentTree::min);
        SegmentTree maxSegmentTree = new SegmentTree(A, SegmentTree::max);

        for(int i=0;i<M;i++){
            int start=in.nextInt()-1,end=in.nextInt()-1;
            System.out.println(String.format("%d %d",A[minSegmentTree.rmq(start,end)],A[maxSegmentTree.rmq(start,end)]));
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

class SegmentTree {
    static int[] A;
    int[] st;
    BiFunction<Integer,Integer,Integer> function;

    public SegmentTree(int[] a, BiFunction<Integer,Integer,Integer> function) {
        A = a;
        this.st = new int[a.length * 4];
        this.function=function;
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
            st[p] = L;
            return;
        }
        build(left(p), L, (L + R) / 2);
        build(right(p), (L + R) / 2 + 1, R);

        int p1 = st[left(p)];
        int p2 = st[right(p)];
        st[p] = function.apply(p1,p2);
    }

    public int rmq(int p, int L, int R, int i, int j) {
        if (j < L || R < i) return -1;
        if (i <= L && R <= j) return st[p];

        int p1 = rmq(left(p), L, (L + R) / 2, i, j);
        int p2 = rmq(right(p), (L + R) / 2 + 1, R, i, j);

        if(p1==-1) return p2;
        if(p2==-1) return p1;
        return function.apply(p1,p2);
    }

    public int rmq(int i, int j) {
        return rmq(1, 0, A.length - 1, i, j);
    }

    private int update_point(int p, int L, int R, int idx, int new_value) {
        if (R < idx || idx < L) return st[p];
        if (L == R && L == idx) {
            A[idx] = new_value;
            return st[p] = idx;
        }

        int p1 = update_point(left(p), L, (L + R) / 2, idx, new_value);
        int p2 = update_point(right(p), (L + R) / 2 + 1, R, idx, new_value);
        st[p] =function.apply(p1,p2);
        return st[p];
    }

    public int update_point(int idx, int new_value) {
        return update_point(1, 0, A.length - 1, idx, new_value);
    }

    public static Integer min(Integer i, Integer j){
        return A[i]<=A[j]?i:j;
    }

    public static Integer max(Integer i, Integer j){
        return A[i]>=A[j]?i:j;
    }

}
