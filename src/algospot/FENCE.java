package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FENCE {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int C=Integer.parseInt(in.readLine().trim());
        for(int i=0;i<C;i++){
            int N=Integer.parseInt(in.readLine().trim());
            int[] fences = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                fences[j]=Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(fences));
        }
    }

    private static int solution(int[] fences) {
        return solve(fences,0,fences.length-1);
    }

    private static int solve(int[] fences, int left, int right) {
        if(left==right) return fences[left];
        int mid=(left+right)/2;
        int ret=Math.max(solve(fences,left,mid),solve(fences,mid+1,right));
        int lo=mid,hi=mid+1;
        int height=Math.min(fences[lo],fences[hi]);
        ret=Math.max(ret,height*2);

        while (left<lo || hi<right){
            if(hi<right &&(lo==left || fences[lo-1]<fences[hi+1])){
                hi++;
                height=Math.min(height,fences[hi]);
            }
            else {
                lo--;
                height=Math.min(height,fences[lo]);
            }
            ret=Math.max(ret,height*(hi-lo+1));
        }
        return ret;
    }
}
