package beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class N9345 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();

        int T=in.nextInt();
        OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(System.out));
        for (int i=0;i<T;i++){
            solution(in,out);
        }
        out.flush();
        out.close();
    }

    private static void solution(FastReader in,OutputStreamWriter out) throws IOException {
        int N=in.nextInt();
        int K=in.nextInt();

        A = new int[N];
        for(int i=0;i<N;i++){
            A[i]=i;
        }

        SegmentTree maxST = new SegmentTree(SegmentTree::max);
        SegmentTree minST = new SegmentTree(SegmentTree::min);

        for(int i=0;i<K;i++){
            int q=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();

            if(q==0){
                int aItem=A[a];
                int bItem=A[b];
                maxST.update(a,bItem);
                maxST.update(b,aItem);

                minST.update(a,bItem);
                minST.update(b,aItem);
            }else{
                int max=maxST.rmq(a,b);
                int min=minST.rmq(a,b);

                if(a>A[min] || A[max]>b) out.write("NO\n");
                else out.write("YES\n");
            }
        }
    }

    static class SegmentTree{
        private int[] st;
        private int n;

        private BiFunction<Integer,Integer,Integer> function;
        public SegmentTree(BiFunction<Integer,Integer,Integer> function){
            n=A.length;
            st=new int[n*4];
            this.function=function;
            build(1,0,n-1);
        }

        private int left(int p){return p<<1;}//p*2
        private int right(int p){return (p<<1)+1;}//p*2+1
        private void build(int p, int L, int R) {
            if(L==R){
                st[p]=L;
                return;
            }

            int mid=(L+R)/2;
            build(left(p),L,mid);
            build(right(p),mid+1,R);

            int p1=st[left(p)];
            int p2=st[right(p)];

            st[p]=function.apply(p1,p2);
        }


        public int rmq(int start,int end){
            return rmq(1,0,n-1,start,end);
        }
        private int rmq(int p,int L,int R,int start,int end){
            if(end<L || start>R) return -1;
            if(L>=start && R<=end) return st[p];

            int mid=(L+R)/2;
            int p1=rmq(left(p),L,mid,start,end);
            int p2=rmq(right(p),mid+1,R,start,end);

            if(p1==-1) return p2;
            if(p2==-1) return p1;

            return function.apply(p1,p2);
        }

        public void update(int idx,int newValue){
            update(1,0,n-1,idx,newValue);
        }
        private int update(int p,int L,int R,int idx,int newValue){
            if(idx<L || idx>R) return st[p];
            if(L==idx && R==idx){
                A[L]=newValue;
                return st[p]=L;
            }

            int mid=(L+R)/2;
            int p1=update(left(p),L,mid,idx,newValue);
            int p2=update(right(p),mid+1,R,idx,newValue);

            return st[p]=function.apply(p1,p2);
        }

        public static int max(int p1,int p2){
            return A[p1]>=A[p2]?p1:p2;
        }

        public static int min(int p1,int p2){
            return A[p1]<=A[p2]?p1:p2;
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
