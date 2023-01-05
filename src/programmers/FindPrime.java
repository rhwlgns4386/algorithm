package programmers;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindPrime {
    public static int len;
    public static ArrayList<Integer> primeList=new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("solution(\"17\") = " + solution("011"));
        System.out.println("args = " + primeList);
    }
    public static int solution(String numbers) {
        ArrayList<Character> characterList =(ArrayList<Character>) numbers.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        len=characterList.size();
        getPrime(characterList,"",0);
        return primeList.size();
    }

    public static void getPrime(ArrayList<Character> numbers,String input,int deep){
        if(len==deep) return;
        for(Character ch:numbers){
            Integer integer = Integer.valueOf(input + ch);
            if(isPrime(integer) && !primeList.contains(integer)){
                primeList.add(integer);
            }
            ArrayList<Character> copyList = new ArrayList<>();
            copyList.addAll(numbers);
            copyList.remove(ch);
            getPrime(copyList,String.valueOf(integer),deep+1);
        }
    }

    public static boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
