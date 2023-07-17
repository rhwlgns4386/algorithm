package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class N1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        ArrayList<String> sa = new ArrayList<>();
        for(int i=0;i<n;i++){
            sa.add(in.readLine());
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(String s:sa){
            for(int i=0;i<s.length();i++){
                int pow = (int)Math.pow(10, s.length()-i-1);
                char c = s.charAt(i);
                map.put(c,map.getOrDefault(c,0)+pow);
            }
        }

        List<Character> collect = map.entrySet().stream().sorted((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue())).map(o -> o.getKey()).collect(Collectors.toList());

        Map<Character,Integer> rankMap=new HashMap<>();
        for(int i=0;i<collect.size();i++){
            rankMap.put(collect.get(i),9-i);
        }

        int result=0;
        for(String s:sa){
            int sum=0;
            for(int i=0;i<s.length();i++){
                int pow = (int)Math.pow(10, s.length()-i-1);
                char c = s.charAt(i);
                sum+=(pow*rankMap.get(c));
            }
            result+=sum;
        }
        System.out.println(result);
    }
}
