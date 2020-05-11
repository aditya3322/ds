package interviewbit.backtracking;

import java.util.ArrayList;

public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> output = new ArrayList<>();
        generate("", A, 0, 0, output);
        return output;
    }

    public void generate(String sb, int A, int open, int close, ArrayList<String> output) {
        if(sb.length() == (2 * A)) {
            output.add(sb.toString());
            return;
        }
        if(open < A) {
            generate(sb + "(", A, (open + 1), close, output);
        }
        if(close < open) {
            generate(sb + ")", A, open, (close + 1), output);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
