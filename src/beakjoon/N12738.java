import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[] a=new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        TreeSet<Integer> treeSet=new TreeSet<>();
        int len=0;
        a[0]=Integer.parseInt(stringTokenizer.nextToken());
        treeSet.add(a[0]);

        for(int i=1; i<n;i++){
            a[i]=Integer.parseInt(stringTokenizer.nextToken());
            try{
                Integer ceiling = treeSet.ceiling(a[i]);
                if(ceiling>a[i]){
                    treeSet.remove(ceiling);
                    treeSet.add(a[i]);
                }
            }catch (NullPointerException e){
                treeSet.add(a[i]);
            }
        }

        System.out.println(treeSet.stream().count());

    }
}
