package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class N1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        //AC
        solution1(in, n);

        //Time out
        solution2(in, n);
    }

    private static void solution2(BufferedReader in, int n) throws IOException {
        int[] L=new int[n];
        for(int i = 0; i< n; i++){
            L[i]=Integer.parseInt(in.readLine());
        }

        int ret=0;
        Arrays.sort(L);
        while (n >1){
            int mii1=0,mii2=1;
            if(L[mii1]>L[mii2]){
                int tem=mii1;
                mii1=mii2;
                mii2=tem;
            }

            for(int i = 2; i< n; i++){
                if(L[i]<L[mii1]){
                    mii2=mii1;
                    mii1=i;
                }else if(L[i]<L[mii2]){
                    mii2=i;
                }
            }

            int t=L[mii1]+L[mii2];
            ret+=t;

            if(mii1== n -1){
                int tem=mii1;
                mii1=mii2;
                mii2=tem;
            }

            L[mii1]=t;
            L[mii2]=L[n -1];
            n--;
        }

        System.out.println(ret);
    }

    private static void solution1(BufferedReader in, int n) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i< n; i++){
            q.add(Integer.parseInt(in.readLine()));
        }

        int ret=0;
        while (q.size()>1){
            int min1=q.remove();
            int min2=q.remove();
            q.add(min1+min2);
            ret+=min2+min1;
        }
        System.out.println(ret);
    }
}
