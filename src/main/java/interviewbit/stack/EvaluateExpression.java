package interviewbit.stack;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<String> stack =  new Stack<>();
        Integer opr1 = null;
        Integer opr2 = null;
        String operand = null;
        for(int i = A.size() - 1; i >= 0; i--) {
           stack.push(A.get(i));
        }
        while(!stack.isEmpty()) {
            String exp = stack.pop();
            Integer value = isNumeric(exp);
            if(value == null) {
                operand = exp;
                opr2 = calculateExpression(opr1, opr2, operand);
                opr1 = null;
                operand = null;
            } else {
                if(opr2 == null) {
                    opr2 = value;
                } else if(opr1 == null) {
                    opr1 = value;
                }
            }
        }
        return opr2;
    }

    public Integer isNumeric(String s) {
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
            return null;
        }
    }

    public Integer calculateExpression(Integer opr1, Integer opr2, String op) {
        switch(op) {
            case "+": return opr1 + opr2;
            case "-": return opr1 - opr2;
            case "/": return opr1 / opr2;
            case "*": return opr1 * opr2;
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("3");//1, 3, -1, -3, 5, 3, 6, 7
        list.add("5");
        list.add("*");
        list.add("3");
        list.add("+");
        list.add("2");
        list.add("-");

        System.out.println(new EvaluateExpression().evalRPN(list));
    }

}
