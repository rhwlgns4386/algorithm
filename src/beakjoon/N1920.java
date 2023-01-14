package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list=new int[N];
        for(int i=0;i<N;i++){
            list[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int M=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(Arrays.binarySearch(list,Integer.parseInt(st.nextToken()))<0){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }
    }
}
