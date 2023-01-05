package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1182 {
    public static int count=0;
    public static int n;
    public static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        n=Integer.parseInt(tokenizer.nextToken());
        s=Integer.parseInt(tokenizer.nextToken());

        int[] nums=new int[n];
        tokenizer = new StringTokenizer(in.readLine(), " ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(tokenizer.nextToken());
        }

        go(nums,0,0);
        System.out.println(count);
    }

    public static void go(int[] nums, int index, int sum){
        if(index==n) return;
        if(sum+nums[index]==s) count++;
        go(nums,index+1,sum+nums[index]);

        go(nums,index+1,sum);

    }
}
