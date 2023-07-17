package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[] a=new int[k];
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<k;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        int count=0;
        for(int i=0;i<k;i++){
            if(list.size()!=n){
                if(!list.contains(a[i])){
                    list.add(a[i]);
                }
            }else{
                if(!list.contains(a[i])){
                    int maxValue=-1;
                    int maxIndex=-1;
                    for(Integer number:list){
                        int index = find(a, number, i);
                        if(maxIndex<index){
                            maxValue=number;
                            maxIndex=index;
                        }
                    }
                    list.remove(list.indexOf(maxValue));
                    list.add(a[i]);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static int find(int[] a,int find ,int start) {
        for(int i=start+1;i<a.length;i++){
            if(a[i]==find){
                return i;
            }
        }
        return a.length;
    }
}
