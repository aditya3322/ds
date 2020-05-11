package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class KthPermutationSequence {
    static int num = 0;
    static String output = "";
    public String getPermutation(int A, int B) {

        List<Integer> list = IntStream.range(1, A + 1).collect(ArrayList::new, List::add, List::addAll);
        generate(new StringBuffer(), list, A, B);
        return "";
    }

    public void generate(StringBuffer s, List<Integer> list,int A, int B) {
        if(s.length() == A) {
           // System.out.println(s.toString());
            num++;
            if(num == B) {
                output = s.toString();
            }
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            if(num != B) {
                s.append(list.get(i));
                ArrayList<Integer> acopy = new ArrayList<>(list);
                acopy.remove(i);
                generate(s, acopy, A, B);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutationSequence().getPermutation(3, 4));
    }
}
