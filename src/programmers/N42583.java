package programmers;


import java.util.LinkedList;
import java.util.Queue;

public class N42583 {
    public static void main(String[] args) {
        solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<bridge_length;i++){
            q.add(0);
        }

        int cnt=0;
        int index=0;
        int qWeight=0;
        while (index<truck_weights.length){
            qWeight-=q.remove();
            cnt++;
            if(qWeight+truck_weights[index]<=weight){
                qWeight+=truck_weights[index];
                q.add(truck_weights[index]);
                index++;

            }else{
                q.add(0);
            }
        }
        while (!q.isEmpty()){
            q.remove();
            cnt++;
        }
        return cnt;
    }
}
