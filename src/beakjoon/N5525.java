package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class N5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(in.readLine());
        int m =Integer.parseInt(in.readLine());
        String s =in.readLine();

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            sb.append("IO");
        }
        sb.append("I");

        String p=sb.toString();
        int[] b=new int[p.length()+1];

        int i=0;
        int j=-1;
        b[0]=-1;
        while (i<p.length()){
            while (j!=-1 && p.charAt(i)!=p.charAt(j)) j=b[j];

            i++;
            j++;
            b[i]=j;
        }

        i=0;j=0;
        int count=0;
        while (i<m){
            while (j>=0 &&s.charAt(i)!=p.charAt(j)) j=b[j];

            i++;
            j++;
            if(j==p.length()){
                count++;
                j=b[j];
            }
        }

        System.out.println(count);
    }
}
