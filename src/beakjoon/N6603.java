package beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N6603 {
    public static int k;
    public static StringBuffer stringBuffer=new StringBuffer();
    public static BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        do {
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
            k=Integer.parseInt(stringTokenizer.nextToken());
            int[] nums = new int[k];
            boolean[] visit=new boolean[k];
            for (int i = 0; i < k; i++) {
                nums[i]=Integer.parseInt(stringTokenizer.nextToken());
            }

            go(nums,visit,0,1);
            out.write("\n");
        }while (k!=0);

        out.flush();
        out.close();
    }

    private static void go(int[] nums, boolean[] visit, int index, int count) throws IOException {
        if(count==7){
            for(int i=0;i<k;i++){
                if(visit[i]){
                    out.write(nums[i]+" ");
                }
            }
            out.write("\n");
            return;
        }

        if(index>=k){
            return;
        }

        visit[index]=true;
        go(nums,visit,index+1,count+1);

        visit[index]=false;
        go(nums,visit,index+1,count);
    }
}
