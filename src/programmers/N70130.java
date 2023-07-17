package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class N70130 {
    public static void main(String[] args) {
        System.out.println(new N70130().solution(new int[]{0,3,3,0,7,2,0,2,2,0}));
    }
    public int solution(int[] a) {
        HashSet<Integer> integers = new HashSet<>();
        Object[] objects = integers.stream().sorted().toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        }).collect(Collectors.toList());


        int result=0;
        for(Map.Entry<Integer, Integer> entry:collect){
           int node=entry.getKey();
           int count=entry.getValue();

           if(count<result) continue;

           int rec=0;
            for(int i=0;i<a.length-1;i++){

                if(a[i]!=node && a[i+1]!=node) continue;
                if(a[i]==a[i+1]) continue;

                rec++;
                i++;
            }

            result=Math.max(result,rec);
        }

        return result*2;
    }
}
