package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class N49189 {
    public static void main(String[] args) {
        System.out.println(solution(2,new int[][]{{1,2}}));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dists=new int[n+1];
        ArrayList<Integer>[] a = new ArrayList[n + 1];

        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int[] edgeNumber = edge[i];
            int start=edgeNumber[0];
            int end=edgeNumber[1];
            a[start].add(end);
            a[end].add(start);
        }

        LinkedList<Integer> q = new LinkedList<>();
        dists[1]=1;
        q.add(1);
        int maxDists=0;
        while (!q.isEmpty()){
            Integer here = q.remove();

            for(int node:a[here]){
                if(dists[node]==0){
                    dists[node]=dists[here]+1;
                    maxDists=Math.max(dists[node],maxDists);
                    q.add(node);
                }
            }
        }


        for(int i=0;i<n+1;i++){
            if(maxDists==dists[i]){
                answer++;
            }
        }

        return answer;
    }
}
