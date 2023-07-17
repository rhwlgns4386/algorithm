package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(in.readLine());
        }

        int before=a[n-1];
        int delete=0;
        for(int i=n-2;0<=i;i--){
            if(before<=a[i]){
                delete+=a[i]-(before-1);
                a[i]=before-1;
            }
            before=a[i];
        }

        System.out.println(delete);
    }
}
