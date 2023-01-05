package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N16564 {
    static int k;
    static ArrayList<Integer> a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());


        a = new ArrayList<>();

        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(in.readLine()));
        }

        Collections.sort(a);

        long left=1;
        long right=1000000000*2;
        long ans=0;
        while (left<=right){
            long mid=(left+right)/2;
            if(canLevelUp(mid)){
                left=mid+1;
                ans=mid;
            }else {
                right=mid-1;
            }
        }
        System.out.println(ans);
    }

    private static boolean canLevelUp(long mid) {
        long cnt=0;
        for(int i=0;i<a.size();i++){
            if(mid>a.get(i)){
                cnt+=mid-a.get(i);
            }
        }

        return cnt<=k;
    }
}
