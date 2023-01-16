package algospot;

import java.io.*;
import java.util.ArrayList;


public class FANMEETING {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(in.readLine().trim());

        for (int i = 0; i < C; i++) {
            char[] members = in.readLine().toCharArray();
            char[] fans = in.readLine().toCharArray();
            ArrayList<Integer> A = new ArrayList<>(), B = new ArrayList<>();
            ensure(members.length, A);
            ensure(fans.length, B);
            for (int j = 0; j < A.size(); j++) A.set(j, (members[j] == 'M') ? 1 : 0);
            for (int j = 0; j < B.size(); j++) B.set(B.size() - j - 1, (fans[j] == 'M') ? 1 : 0);
            out.write(String.format("%d\n",solution(A, B)));
        }

        out.flush();
        out.close();
    }

    private static Integer solution(ArrayList<Integer> members, ArrayList<Integer> fans) {
        int N = members.size(), M = fans.size();
        ArrayList<Integer> C = karatsuba(members, fans);
        int count = 0;
        for (int i = N - 1; i < M; ++i) {
            if (C.get(i) == 0) count++;
        }
        return count;
    }

    private static ArrayList<Integer> karatsuba(ArrayList<Integer> a, ArrayList<Integer> b) {
        int an = a.size(), bn = b.size();

        if (an < bn) return karatsuba(b, a);

        if (an == 0 || bn == 0) return new ArrayList<Integer>();

        if (an <= 50) return multiply(a, b);

        int half = an / 2;

        ArrayList<Integer> a0 = new ArrayList<>(a.subList(0, half));
        ArrayList<Integer> a1 = new ArrayList<>(a.subList(half, a.size()));
        ArrayList<Integer> b0 = new ArrayList<>(b.subList(0, Math.min(half, b.size())));
        ArrayList<Integer> b1 = new ArrayList<>(b.subList(Math.min(half, b.size()), b.size()));

        ArrayList<Integer> z2 = karatsuba(a1, b1);
        ArrayList<Integer> z0 = karatsuba(a0, b0);

        addTo(a0, a1, 0);
        addTo(b0, b1, 0);

        ArrayList<Integer> z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);

        ArrayList<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half + half);

        return ret;
    }

    private static ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();
        ensure(a.size() + b.size() + 1, c);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                c.set(i + j, a.get(i) * b.get(j) + c.get(i + j));
            }
        }

//        normalize(c);
        return c;
    }

    private static void addTo(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
        ensure(Math.max(a.size(), b.size() + k), a);
        for (int i = 0; i < b.size(); i++) {
            a.set(i + k, a.get(i + k) + b.get(i));
        }
//        normalize(a);
    }

    private static void subFrom(ArrayList<Integer> a, ArrayList<Integer> b) {
        ensure(Math.max(a.size(), b.size()) + 1, a);
        for (int i = 0; i < b.size(); i++) {
            a.set(i, a.get(i) - b.get(i));
        }
//        normalize(a);
    }

//    private static void normalize(ArrayList<Integer> c) {
//        c.add(0);
//        for(int i=0;i+1<c.size();++i){
//            if(c.get(i)<0){
//                int borrow=(Math.abs(c.get(i))+9)/10;
//                c.set(i+1,c.get(i+1)-borrow);
//                c.set(i,c.get(i)+(borrow*10));
//            }else{
//                c.set(i+1,c.get(i)/10+c.get(i+1));
//                c.set(i,c.get(i)%10);
//            }
//        }
//        while (c.size()>1&&c.get(c.size()-1)==0) c.remove(c.size()-1);
//    }

    private static void ensure(int size, ArrayList<Integer> c) {
        c.ensureCapacity(size);
        while (c.size() < size) {
            c.add(0);
        }

    }

}
