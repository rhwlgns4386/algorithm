package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);

        int left=0;
        int right=n-1;

        int min=Integer.MAX_VALUE;
        int[] ans=new int[2];
        while (left<right){
            int sum=a.get(left)+a.get(right);
            if(Math.abs(sum)<min){
                min=Math.abs(sum);
                ans[0]=a.get(left);
                ans[1]=a.get(right);
            }

            if(sum<0)left++;
            else if(sum>0) right--;
            else break;
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}
