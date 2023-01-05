package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1253 {
    static ArrayList<Integer> a;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        a = new ArrayList<>();

        for(int i=0;i<n;i++){
            int tem=Integer.parseInt(st.nextToken());
            a.add(tem);
        }

        Collections.sort(a);

        int ans=0;
        for(int i=0;i<n;i++){
            int findNumber=a.get(i);

            int left=0;
            int right=n-1;
            int sum=0;

            while (left<right){
                sum=a.get(left)+a.get(right);
                if(findNumber==sum){
                    if(left==i){
                        left++;
                    }else if(right==i){
                        right--;
                    }else {
                        ans++;
                        break;
                    }
                }

                if(sum>findNumber) right--;
                else if(sum<findNumber) left++;
            }
        }
        System.out.println(ans);
    }
}
