package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1322 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] xBinaryArray=makeBinaryArray(X);
        int[] kBinaryArray=makeBinaryArray(K);

        ArrayList<Integer> xOfZeroIndexList = new ArrayList<>();
        for(int i=0;i<64;i++){
            if(xBinaryArray[i]==0){
                xOfZeroIndexList.add(i);
            }
        }

        int[] result=new int[64];
        for(int i=0;i<64;i++){
            if(kBinaryArray[i]==1){
                result[xOfZeroIndexList.get(i)]=1;
            }
        }

        System.out.println(toDecimal(result));
    }

    private static long toDecimal(int[] binaryArray) {
        long sum=0l;
        for(int i=0;i<64;i++){
            sum+= binaryArray[i]*((long)1<<i);
        }
        return sum;
    }

    private static int[] makeBinaryArray(int x) {
        int[] binaryArray = new int[64];
        for(int i=0;i<64;i++){
            if((x&1)==1){
                binaryArray[i]=1;
            }
            x=x>>1;
        }
        return binaryArray;
    }
}
