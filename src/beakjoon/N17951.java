package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17951 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(in.readLine());
        int[] a = new int[n];
        int left=1;
        int right=0;
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
            right+=a[i];
        }

        while (left<=right){
            int mid=(right+left)/2;
            int cnt=1;
            int sum=0;

            for(int i=0;i<n;i++){
               sum+=a[i];
                if(sum>=mid){
                    cnt++;
                    sum=0;
                }
            }

            if(cnt>k) left=mid+1;
            else right=mid-1;
        }
        System.out.println(left-1);
    }
}
