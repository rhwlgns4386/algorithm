package programmers.kakao2024Internship;

import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {
    //이번달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측 프로그램
    /*
    룰 :
    두사람 사이에 선물 받은 기록중 두사람중 덜 준사람이 더 준 사람에게 준다
    같거나 없다면 선물 지수가 낮은 사람이 높은 사람에게 준다
    선물 지수 : 한사람의 준선물 - 받은 선물(음수 가능)
    선물지수도 같다면 아무것도 하지 않음
     */
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"muzi","ryan","frodo","neo"},new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));;
    }

    static class Solution {
        public int solution(String[] friends, String[] gifts) {

            HashMap<String, Integer> giveIndices=new HashMap<>();
            HashMap<String,Integer> giveHistory=new HashMap<>();

            for(int i=0;i<gifts.length;i++){
                String[] split = gifts[i].split(" ");
                String give = split[0];
                String receive = split[1];
                giveIndices.put(give,giveIndices.getOrDefault(give,0)+1);
                giveIndices.put(receive,giveIndices.getOrDefault(receive,0)-1);
                giveHistory.put(gifts[i],giveHistory.getOrDefault(gifts[i],0)+1);
            }

            int[] answer=new int[friends.length];
            for(int i=0;i<friends.length;i++){
                int result=0;
                for(int j=0;j<friends.length;j++){
                    if(i==j) continue;
                    if(giveHistory.containsKey(friends[i]+" "+friends[j]) || giveHistory.containsKey(friends[j]+" "+ friends[i])){
                        Integer give = giveHistory.getOrDefault(friends[i] + " " + friends[j], 0);
                        Integer receive = giveHistory.getOrDefault(friends[j]+" "+ friends[i], 0);
                        if(give>receive){
                            result++;
                            continue;
                        }else if(receive>give){
                            continue;
                        }
                    }

                    Integer me = giveIndices.getOrDefault(friends[i], 0);
                    Integer target = giveIndices.getOrDefault(friends[j], 0);
                    if(target<me){
                        result++;
                    }
                }

                answer[i]=result;
            }

            int max=0;
            for(int i=0;i<answer.length;i++){
                max=Math.max(answer[i],max);
            }

            return max;
        }
    }

}
