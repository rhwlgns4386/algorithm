package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10999 {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();

        int N=in.nextInt();
        int M=in.nextInt();
        int K=in.nextInt();
        long[] A = new long[N];
        for(int i=0;i<N;i++){
            A[i]=in.nextLong();
        }

        SegmentTree st = new SegmentTree(A);
        for(int i=0;i<M+K;i++){
            int q=in.nextInt();
            if(q==1){
                int start=in.nextInt()-1;
                int end=in.nextInt()-1;
                long k=in.nextLong();

                st.update(start,end,k);
            }else{
                int start=in.nextInt()-1;
                int end=in.nextInt()-1;
                System.out.println(st.rmq(start,end));;
            }
        }
    }



    private static class SegmentTree {
        private long [] A;
        private long[] st,lazy;
        private int n;
        public SegmentTree(long[] a) {
            A=a;
            n=A.length;
            this.st=new long[n*4];
            this.lazy=new long[n*4];
            build(1,0,n-1);
        }

        private void build(int p, int L, int R) {
            if(L==R){
                st[p]=A[L];
                return;
            }
            int mid=(L+R)/2;
            build(left(p),L,mid);
            build(right(p),mid+1,R);

            long p1=st[left(p)];
            long p2=st[right(p)];

            st[p]=p1+p2;
        }


        public long rmq(int start,int end) {
            return rmq(1,0,n-1,start,end);
        }

        private long rmq(int p, int L, int R, int i, int j) {
            updateLazy(p,L,R);
            if(j<L || i>R) return 0;
            if(i<=L && j>=R) return st[p];

            int mid=(L+R)/2;
            long p1=rmq(left(p),L,mid,i,j);
            long p2=rmq(right(p),mid+1,R,i,j);

            return p1+p2;
        }

        public void update(int start, int end, long k) {
            update(1,0,n-1,start,end,k);
        }

        private long update(int p, int L, int R, int i, int j, long k) {
            updateLazy(p,L,R);
            if(j<L || i>R) return st[p];
            if(i<=L &&R<=j){
                st[p]+=(R-L+1)*k;
                if(L!=R){
                    lazy[left(p)]+=k;
                    lazy[right(p)]+=k;
                }
                return st[p];
            }

            int mid=(L+R)/2;
            long p1=update(left(p),L,mid,i,j,k);
            long p2=update(right(p),mid+1,R,i,j,k);

            return st[p]=p1+p2;
        }

        private void updateLazy(int p,int L,int R){
            if(lazy[p]!=0){
                st[p]+=(R-L+1)*lazy[p];
                if(L!=R){
                    lazy[left(p)]+=lazy[p];
                    lazy[right(p)]+=lazy[p];
                }
                lazy[p]=0;
            }
        }

        private int right(int p) {
            return (p<<1)+1;
        }

        private int left(int p) {
            return p<<1;
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
