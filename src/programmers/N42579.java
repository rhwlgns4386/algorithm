package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class N42579 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},new int[]{500, 600, 150, 800, 2500})));;
    }
    static class Pair implements Comparable<Pair>{
        int index;
        int play;

        public Pair(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.play<o.play){
                return 1;
            }else if(this.play==o.play){
                if(this.index<o.index){
                    return -1;
                }else if(this.index==o.index){
                    return 0;
                }else{
                    return 1;
                }
            }
            else {
                return -1;
            }
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,PriorityQueue<Pair>> playMap=new HashMap<>();
        HashMap<String,Integer> sumMap=new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0;i<genres.length;i++){
            if(!playMap.containsKey(genres[i])){
                PriorityQueue<Pair> q = new PriorityQueue<>();
                q.add(new Pair(i,plays[i]));
                playMap.put(genres[i],q);

                sumMap.put(genres[i], 0);
            }else{
                PriorityQueue<Pair> q = playMap.get(genres[i]);
                q.add(new Pair(i,plays[i]));
            }
            sumMap.put(genres[i],sumMap.get(genres[i])+plays[i]);
        }

        List<Map.Entry<String, Integer>> collect = sumMap.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else if (o1.getValue() == o2.getValue()) {
                return 0;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());

        for (Map.Entry<String, Integer> e : collect) {
            PriorityQueue<Pair> pairs = playMap.get(e.getKey());
            for(int i=0;i<2;i++){
                if(!pairs.isEmpty()){
                    Pair remove = pairs.remove();
                    a.add(remove.index);
                }
            }
        }
        return a.stream().mapToInt(i->i).toArray();
    }
}
