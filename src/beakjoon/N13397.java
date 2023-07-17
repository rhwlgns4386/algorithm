package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13397 {

    private static int n;
    private static int m;
    private static int[] a;
    private static int MAX=10000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(in.readLine());
        int hi=0;
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
            hi = Math.max(a[i],hi);
        }

        System.out.println(parametricSearch(hi));
    }

    private static int parametricSearch(int hi) {
        int lo=-1;
        while(lo+1<hi){
            int mid=(lo+hi)/2;
            if(makeArray(mid)<=m){
                hi=mid;
            }else{
                lo=mid;
            }
        }

        return hi;
    }

    private static int makeArray(int mid) {
        int max=-MAX;
        int min=MAX;
        int count=1;
        for(int i=0;i<n;i++){
            max=Math.max(max,a[i]);
            min=Math.min(min,a[i]);
            if(max-min>mid){
                count++;
                max=a[i];
                min=a[i];
            }
        }
        return count;
    }
}
