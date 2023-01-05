package beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1933 {
    public static class Pair{
        int x;
        int y;
        int height;

        public Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public String toString() {
            return "beakjoon.Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", height=" + height +
                    '}';
        }
    }

    public static Pair[] pairs;
    public static Pair[] tem;
    public static Pair endPointPair=new Pair(0,0,0);
    public static Pair hiPair=new Pair(0,0,0);
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(in.readLine());
        pairs=new Pair[n];
        tem=new Pair[n];

        for(int i=0;i<n;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
            int x=Integer.parseInt(stringTokenizer.nextToken());
            int height=Integer.parseInt(stringTokenizer.nextToken());
            int y=Integer.parseInt(stringTokenizer.nextToken());

            pairs[i]=new Pair(x,y,height);
        }

        mergeShort(0,n-1);

        for(int i=0;i<n;i++){
           Pair pair=pairs[i];
           if(pair.x> endPointPair.y){
               bufferedWriter.append(endPointPair.y+" "+ 0+" ");
               endPointPair=new Pair(0,0,0);
               hiPair=new Pair(0,0,0);
           }

           if(pair.height> hiPair.height){
               hiPair=pair;
               bufferedWriter.append(hiPair.x+" "+ hiPair.height+" ");
           }

           if(endPointPair.y< pair.y){
               endPointPair=pair;
           }

        }
    }

    private static void mergeShort(int start, int end) {
        if(start==end){
            return;
        }

        int mid=(end+start)/2;
        mergeShort(start,mid);
        mergeShort(mid+1,end);

        merge(start,end);
    }

    private static void merge(int start, int end) {
        {
            int mid=(end+start)/2;

            int i=start,j=mid+1,k=0;

            while (i<=mid&&j<=end){
                if(pairs[i].x<pairs[j].x) tem[k++]=pairs[i++];
                else if(pairs[i].x==pairs[j].x){
                    if(pairs[i].height<=pairs[j].height) tem[k++]=pairs[i++];
                    else tem[k++]=pairs[j++];
                }
                else tem[k++]=pairs[j++];
            }
            while (i<=mid) tem[k++]=pairs[i++];
            while (j<=end) tem[k++]=pairs[j++];
        }

        for(int i=start;i<=end;i++){
            pairs[i]=tem[i-start];
        }
    }
}
