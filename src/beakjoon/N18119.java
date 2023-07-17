package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N18119 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int N = in.nextInt();
        int M = in.nextInt();
        int tem=(1 << 27) - 1;
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            String s = in.nextLine();
            int bineryInt=toBineryInt(s);
            a[i]=bineryInt;
        }


        OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(System.out));
        for(int i=0;i<M;i++){
            int o = in.nextInt();
            String x=in.nextLine();

            if(o==1){
                tem &=~(1<<(x.charAt(1)-'a'));
            }else{
                tem |=(1<<(x.charAt(1)-'a'));
            }

            int count=0;
            for (int j=0;j<a.length;j++){
                if((tem&a[j])>=a[j])count++;
            }

            out.write(count+"\n");
        }

        out.flush();
        out.close();
    }

    private static int toBineryInt(String s) {
        int bineryInt=0;
        for(int i=0;i<s.length();i++){
            bineryInt|=1<<(s.charAt(i)-'a');
        }
        return bineryInt;
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
