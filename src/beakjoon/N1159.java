package beakjoon;

import java.util.*;
import java.util.stream.Collectors;

public class N1159 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();

        for(int i=0;i<n;i++){
            char c = in.next().charAt(0);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Character> collect = entries.stream().filter(e->e.getValue()>=5).map(e->e.getKey()).sorted().collect(Collectors.toList());

        if(collect.size()==0){
            System.out.println("PREDAJA");
        }else{
            for(Character c:collect){
                System.out.print(c);
            }
        }
    }
}
