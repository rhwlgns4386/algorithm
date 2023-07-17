package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(in.readLine());
        }

        int result=0;
        int before=0;
        for (int i=n-1;i>=0;i--){
            if(a[i]>before){
                result++;
                before=a[i];
            }
        }

        System.out.println(result);
    }
}
