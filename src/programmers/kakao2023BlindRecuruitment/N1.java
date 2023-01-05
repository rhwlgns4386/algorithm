package programmers.kakao2023BlindRecuruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class N1 {
    public static void main(String[] args) {
        System.out.println(makeDaytoInt("2000.01.01"));
        System.out.println(Arrays.toString(solution("2022.05.19",new String[]{"A 6", "B 12", "C 3"},new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }
    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans=new ArrayList<>();
        int dayNum=makeDaytoInt(today);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<terms.length;i++){
            String[] s = terms[i].split(" ");
            int key=s[0].charAt(0)-'A';
            map.put(key,Integer.parseInt(s[1])*28);
        }

        for(int i=0;i<privacies.length;i++){
            String[] s = privacies[i].split(" ");
            int privacieNum = makeDaytoInt(s[0]);
            int key=s[1].charAt(0)-'A';
            if(dayNum>=privacieNum+map.get(key)){
                ans.add(i+1);
            }
        }

        return ans.stream().mapToInt(i->i).toArray();
    }

    private static int makeDaytoInt(String day) {
        String[] daylist = day.split("[.]");

        return (Integer.parseInt(daylist[0])-2000)*336+(Integer.parseInt(daylist[1])-1)*28+Integer.parseInt(daylist[2]);
    }
}
