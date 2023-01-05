package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14225 {
    public static boolean[] check=new boolean[100000*20+1];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        int n=Integer.parseInt(in.readLine());
        int[] nums=new int[n];

        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(tokenizer.nextToken());
        }

        go(nums,0,0);
        int ans=0;
        for(int i=1;i<check.length;i++){
            if(!check[i]){
                ans=i;
                break;
            }
        }
        System.out.println(ans);
    }

    private static void go(int[] nums, int index,int sum) {
        if(index==nums.length) return;
        check[sum+nums[index]]=true;
        go(nums,index+1,sum+nums[index]);

        go(nums,index+1,sum);
    }
}
