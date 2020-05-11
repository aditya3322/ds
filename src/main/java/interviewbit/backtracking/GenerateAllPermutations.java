package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateAllPermutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        generate(output, A, 0, new ArrayList<>());
        return  output;
    }

    public void generate(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> A, int index, ArrayList<Integer> tempList) {
        if(tempList.size() == A.size()) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < A.size(); i++) {
            tempList.add(A.get(i));
            ArrayList<Integer> acopy = new ArrayList<>(A);
            acopy.remove(i);
            generate(output, acopy, 0, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateAllPermutations().permute(new ArrayList<>(Arrays.asList(1,2 ,3))));
    }
}
