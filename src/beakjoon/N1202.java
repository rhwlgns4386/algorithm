import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
* input
* 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)

다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)

다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)

모든 숫자는 양의 정수이다.
*
* ouput
* 첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
* ex
2 1
5 10
100 100
11
* */
public class N1202 {
    static class Jewel implements Comparable<Jewel>{
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.v > o.v) {
                return -1;
            } else if (this.v == o.v) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int k=Integer.parseInt(tokenizer.nextToken());
        Jewel[] jewels=new Jewel[n];

        for(int i=0;i<n;i++){
            tokenizer=new StringTokenizer(in.readLine()," ");
            int m=Integer.parseInt(tokenizer.nextToken());
            int v=Integer.parseInt(tokenizer.nextToken());

            jewels[i]=new Jewel(m,v);
        }

        Arrays.sort(jewels);

        TreeMap<Integer,Integer> tree=new TreeMap<>();

        for(int i=0;i<k;i++){
            int c=Integer.parseInt(in.readLine());
            Integer val = tree.get(c);
            if(val==null){
                val=0;
            }
            val+=1;
            tree.put(c,val);
        }

        long ans=0;
        for (int i=0; i<n; i++) {
            Map.Entry<Integer, Integer> entry = tree.ceilingEntry(jewels[i].m);
            if(entry!=null){
                ans+=jewels[i].v;
                Integer key = entry.getKey();
                Integer val = entry.getValue()-1;
                if(val==0){
                    tree.remove(key);
                } else {
                    tree.put(key,val);
                }
            }
        }
        System.out.println(ans);

    }
}
