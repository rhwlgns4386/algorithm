import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2110 {
    static int n,c;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(in.readLine()));
        }

        Collections.sort(a);

        int left=1;
        int right=a.get(n-1)-a.get(0);

        int ans=left;

        while (left<=right){
            int mid=(right+left)/2;

            if(check(a,mid)){
                if(ans<mid){
                    ans=mid;
                }
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(ArrayList<Integer> a, int mid) {
        int cnt=1;
        int last=a.get(0);
        for(Integer i:a){
            if(i-last>=mid){
                last=i;
                cnt++;
            }
        }

        return cnt>=c;
    }
}
