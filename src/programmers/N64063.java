package programmers;
import java.util.*;

public class N64063 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(10,new long[]{1,3,4,1,3,1})));
    }

    static class Solution {
        HashMap<Long,Long> p=new HashMap<>();
        HashMap<Long,Long> rank=new HashMap<>();
        HashMap<Long,Long> max=new HashMap<>();

        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];
            for (int i=0;i<room_number.length;i++){
                if(!containSet(room_number[i])){
                    p.put(room_number[i],room_number[i]);
                    rank.put(room_number[i],1L);
                    max.put(room_number[i],room_number[i]);

                    answer[i]=room_number[i];
                    if(0<(room_number[i]-1)&&containSet(room_number[i]-1)){
                        unionSet(room_number[i],room_number[i]-1);
                    }
                    if((room_number[i]+1)<=k&&containSet(room_number[i]+1)){
                        unionSet(room_number[i],room_number[i]+1);
                    }
                }else{
                    Long maxValue = getMax(room_number[i])+1;
                    p.put(maxValue,maxValue);
                    rank.put(maxValue,1L);
                    max.put(maxValue,maxValue);

                    answer[i]=maxValue;
                    if(containSet(maxValue-1)){
                        unionSet(maxValue,maxValue-1);
                    }
                    if(containSet(maxValue+1)){
                        unionSet(maxValue,maxValue+1);
                    }
                }
            }

            return answer;
        }

        public void unionSet(long i,long j){
            if(isSame(i,j)) return;
            long x=findSet(i);
            long y=findSet(j);

            long maxValue = Math.max(getMax(x), getMax(y));
            max.put(x,maxValue);
            max.put(y,maxValue);

            if(rank.get(x)>rank.get(y)){
                p.put(y,x);
            }else{
                p.put(x,y);
                if(rank.get(x)==rank.get(y)){
                    rank.put(y,rank.get(y)+1);
                }
            }
        }

        public Long getMax(long i){
            return max.get(findSet(i));
        }
        public boolean containSet(long i){
            return p.containsKey(i);
        }

        public boolean isSame(long i,long j){
            return findSet(i)==findSet(j);
        }
        public long findSet(long i){
            if(i==p.get(i)){
                return i;
            }else{
                long set = findSet(p.get(i));
                p.put(i,set);
                return set;
            }
        }
    }
}
