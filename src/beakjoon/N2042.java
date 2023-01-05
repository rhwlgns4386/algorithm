package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2042 {
    static long[] a;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");

        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());
        int k=Integer.parseInt(stringTokenizer.nextToken());


        a=new long[n+1];
        tree=new long[n+1];

        for(int i=1;i<=n;i++){
            a[i]=Long.parseLong(in.readLine());
            update(i,a[i]);
        }

        for(int i=0;i<m+k;i++){
            stringTokenizer = new StringTokenizer(in.readLine(), " ");
            int a1=Integer.parseInt(stringTokenizer.nextToken());
            int b=Integer.parseInt(stringTokenizer.nextToken());
            long c=Long.parseLong(stringTokenizer.nextToken());

            if(a1==1){
                update(b,c-a[b]);
                a[b]=c;
            }else {
                System.out.println(sum((int)c)-sum(b-1));
            }
        }
    }

    private static long sum(int index) {
        long ans=0;
        for(int i=index;i>0;i-=i&-i){
            ans+=tree[i];
        }
        return ans;
    }

    private static void update(int index, long diff) {
        for(int i=index;i<tree.length;i+=i&-i){
            tree[i]+=diff;
        }
    }
}
