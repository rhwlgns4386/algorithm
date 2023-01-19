package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N12899 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int n=in.nextInt();

        int[] A = new int[2000000 + 1];
        SegmentTree st = new SegmentTree(A);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++){
            int T = in.nextInt();
            if(T==1){
                st.update(in.nextInt());
            }else{
                int X = in.nextInt();
                int result=st.rmq(X);
                st.remove(result);
                sb.append(result+"\n");
            }
        }

        System.out.println(sb);
    }

    private static class SegmentTree {
        private int[] A,st;
        private int n;
        public SegmentTree(int[] a) {
            A=a;
            n=A.length;
            this.st=new int[n*4];
        }

        public void update(int X){
            update(1,1,n-1,X,1);
        }

        private void remove(int X){
            update(1,1,n-1,X,-1);
        }

        private int update(int p, int L, int R, int idx,int val) {
            if(idx<L || R<idx) return st[p];
            if(L==idx &&R==idx){
                A[idx]+=val;
                st[p]+=val;
                if(A[idx]<0){
                    A[idx]=0;
                    st[p]=0;
                }
                return st[p];
            }

            int mid=(L+R)/2;
            int p1=update(left(p),L,mid,idx,val);
            int p2=update(right(p),mid+1,R,idx,val);

            return st[p]=p1+p2;
        }

        public int rmq(int x) {
            return rmq(1,1,n-1,x);
        }

        private int rmq(int p, int L, int R, int x) {
            if(L==R){
                return L;
            }

            int mid =(L+R)/2;
            if(x>st[left(p)]){
                return rmq(right(p),mid+1,R,x-st[left(p)]);
            }else {
                return rmq(left(p),L,mid,x);
            }
        }

        private int left(int p) {
            return p<<1;
        }

        private int right(int p) {
            return (p<<1)+1;
        }
    }

    //출처 : https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/amp/
    static class Reader {

        BufferedReader br;

        StringTokenizer st;



        public Reader()

        {

            br = new BufferedReader(

                    new InputStreamReader(System.in));

        }



        String next()

        {

            while (st == null || !st.hasMoreElements()) {

                try {

                    st = new StringTokenizer(br.readLine());

                }

                catch (IOException e) {

                    e.printStackTrace();

                }

            }

            return st.nextToken();

        }



        int nextInt() { return Integer.parseInt(next()); }



        long nextLong() { return Long.parseLong(next()); }



        double nextDouble()

        {

            return Double.parseDouble(next());

        }



        String nextLine()

        {

            String str = "";

            try {

                if(st.hasMoreTokens()){

                    str = st.nextToken("\n");

                }

                else{

                    str = br.readLine();

                }

            }

            catch (IOException e) {

                e.printStackTrace();

            }

            return str;

        }

    }
}
