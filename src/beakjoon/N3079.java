import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(in.readLine()));
        }

        Collections.sort(a);
        long left=0L;
        long right=a.get(n-1)*1000000000L;
        long ans=0L;

        while (left<=right){
            long mid=(left+right)/2;
            long cnt=0;
            for(Integer i:a){
                cnt+=(mid/i);
            }

            if(cnt>=m){
                ans=mid;
                right=mid-1;
            }
            else if (cnt < m){
                left = mid +1;

            }
        }
        System.out.println(ans);
    }
}
