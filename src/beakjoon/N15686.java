package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N15686 {

    private static ArrayList<int[]> house;
    private static ArrayList<int[]> chicken;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j< n; j++){
                int number=Integer.parseInt(st.nextToken());
                if(number==1){
                    house.add(new int[]{i,j});
                }else if(number==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }

        System.out.println(go(new ArrayList<>()));
    }

    private static int go(ArrayList<Integer> a) {
        if(m==a.size()){
            return calsceDist(a);
        }

        int lastIndex=a.isEmpty()?0:a.get(a.size()-1)+1;

        int result=Integer.MAX_VALUE;
        for(int i=lastIndex;i<chicken.size();i++){
            a.add(i);
            result=Math.min(result,go(a));
            a.remove(a.size()-1);
        }

        return result;
    }

    private static int calsceDist(ArrayList<Integer> a) {
        int sum=0;
        for(int[] hNode:house){
            int hx = hNode[0];
            int hy = hNode[1];

            int dist=Integer.MAX_VALUE;
            for(Integer index: a){
                int[] cNode = chicken.get(index);
                int cx = cNode[0];
                int cy = cNode[1];

                dist=Math.min(Math.abs(hx-cx)+Math.abs(hy-cy),dist);
            }
            sum+=dist;
        }

        return sum;
    }
}
