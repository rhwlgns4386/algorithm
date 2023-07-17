package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class N1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char alphabet = s.charAt(i);
            map.put(alphabet,map.getOrDefault(alphabet,0)+1);
        }

        List<Map.Entry> odd = map.entrySet().stream().filter(i -> i.getValue() % 2 != 0).collect(Collectors.toList());
        if(odd.size()>1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        List<Map.Entry<Character, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> {
            return Character.compare(o1.getKey(), o2.getKey());
        }).collect(Collectors.toList());

        for(Map.Entry entry:collect){
            for(int i=0;i<(int)entry.getValue()/2;i++){
                sb.append(entry.getKey());
            }
        }

        StringBuilder revers = new StringBuilder(sb);
        revers.reverse();
        if(odd.size()!=0){
            sb.append(odd.get(0).getKey());
        }
        sb.append(revers);
        System.out.println(sb);
    }
}
