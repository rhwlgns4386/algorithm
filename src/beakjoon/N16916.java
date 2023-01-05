package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class N16916 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String T=in.readLine();
        String P=in.readLine();
        System.out.println(kmp(T,P));
    }


    static int[] preprocessing(String p){
        int m=p.length();
        int[] pi=new int[m];
        pi[0]=0;
        int j=0;

        for(int i=1;i<m;i++){
            while (j>0 && p.charAt(i)!=p.charAt(j)) j=pi[j-1];
            if(p.charAt(i)==p.charAt(j)){
                pi[i]=j+1;
                j+=1;
            }else {
                pi[i]=0;
            }
        }
        return pi;
    }

    static ArrayList<Integer> kmp(String s, String p){
        int n = s.length();
        int m=p.length();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int[] pi = preprocessing(p);

        int j=0;
        for(int i=0;i<n;i++){
            while (j>0 && s.charAt(i)!=p.charAt(j)) j=pi[j-1];
            if(s.charAt(i)==p.charAt(j)){
                if(j==m-1){
                    ans.add(i-m+2);
                    j=pi[j];
                }else {
                    j+=1;
                }
            }
        }
        return ans;
    }
}
