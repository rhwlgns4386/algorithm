package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N14586 {

    static class Pair implements Comparable<Pair>{
        long index;
        long height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o){
            if(this.index<o.index){
                return -1;
            }else if(this.index==o.index){
                if(this.height<o.height){
                    return -1;
                }else if(this.height==o.height){
                    return 0;
                }else{
                    return 1;
                }
            }else {
                return 1;
            }
        }
    }
    static ArrayList<Pair> a=new ArrayList<>();
    static int[] left;//어떤 n을 눕혔을때 몇번째까지 아이템까지 눕힐수 있냐
    static int[] right;
    static int[][] dp=new int[301][301];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer n=Integer.parseInt(in.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int index=Integer.parseInt(st.nextToken());
            int height=Integer.parseInt(st.nextToken());
            a.add(new Pair(index,height));
        }

        Collections.sort(a);

        left=new int[500000];
        right=new int[500000];

        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        for(int i=0;i<n;i++){
            findLeft(i);
            findRight(i);
        }

        for(int i=0;i<301;i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(func(0,n-1));
    }

    private static int func(int a, int b) {
        if(a<0 || b<0) return 0;
        if(a>b) return dp[a][b]=0;
        if(dp[a][b]!=-1) return dp[a][b];

        if(right[a]>=b || left[b]<=a) return dp[a][b]=1;

        dp[a][b]=1000000000;
        for(int i=a;i<=b;i++){
            dp[a][b]=Math.min(func(a,left[i]-1)+func(left[i],right[i])+func(right[i]+1,b),dp[a][b]);
        }
        return dp[a][b];
    }

    private static int findRight(int here) {
        if(right[here]!=-1) return right[here];

        Pair pair = a.get(here);
        long index=pair.index;
        long height=pair.height;

        int l = upperBound(index+height);

        right[here]=l-1;
        for(int t=here;t<l;t++){
            right[here]=Math.max(right[here],findRight(t));
        }

        return right[here];
    }

    private static int findLeft(int here) {
        if(left[here]!=-1) return left[here];

        Pair pair = a.get(here);
        long index=pair.index;
        long height=pair.height;

        int l = lowerBound(index - height);

        left[here]=l;
        for(int t=l;t<here;t++){
            left[here]=Math.min(left[here],findLeft(t));
        }

        return left[here];
    }

    public static int lowerBound(long target){
        int begin=-1;
        int end=a.size();

        while (begin+1<end){
            int mid=(end+begin)/2;

            if(!(a.get(mid).index>=target)){
                begin=mid;
            }
            else{
                end=mid;
            }
        }
        return end;
    }

    public static int upperBound(long target){

        int begin=-1;
        int end=a.size();

        while (begin+1<end){
            int mid=(end+begin)/2;

            if(!(a.get(mid).index>target)){
                begin=mid;
            }
            else{
                end=mid;
            }
        }
        return end;
    }
}
