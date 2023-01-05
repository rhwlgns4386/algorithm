package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1477 {
    static  ArrayList<Integer> a;
    static int n,m,l;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(in.readLine());
        a = new ArrayList<>();

        a.add(0);
        a.add(l);
        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);

        int left=1;
        int right=l;

        while (left<=right){
            int mid=(right+left)/2;
            if(canMake(mid)) left=mid+1;
            else right=mid-1;
        }
        System.out.println(left);
    }

    private static boolean canMake(int mid) {
        int count=0;
        for(int i=1;i<a.size();i++){
            count+=(a.get(i)- a.get(i-1)-1)/mid;
        }
        return count>m;
    }
}
