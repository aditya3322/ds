package interviewbit.backtracking;

import java.util.*;

public class LetterPhone {

public ArrayList<String> letterCombinations(String A) {
    ArrayList<String> output = new ArrayList<>();
    Map<Character, List<String>> map = new HashMap<>();
    map.put('1', Arrays.asList("1"));
    map.put('2', Arrays.asList("a", "b", "c"));
    map.put('3', Arrays.asList("d", "e", "f"));
    map.put('4', Arrays.asList("g", "h", "i"));
    map.put('5', Arrays.asList("j", "k", "l"));
    map.put('6', Arrays.asList("m", "n", "o"));
    map.put('7', Arrays.asList("p", "q", "r", "s"));
    map.put('8', Arrays.asList("t", "u", "v"));
    map.put('9', Arrays.asList("w", "x", "y", "z"));
    map.put('0', Arrays.asList("0"));

    generate(map, A, output, new StringBuffer(""));


    return output;
}

public void generate(Map<Character, List<String>> map, String A, ArrayList<String> output, StringBuffer sb) {
    if(sb.length() == A.length()) {
        output.add(sb.toString());
        return;
    }
    for(String s: map.get(A.charAt(sb.length()))) {
        sb.append(s);
        generate(map, A, output, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}

public static void main(String[] args) {
    System.out.println(new LetterPhone().letterCombinations("23"));
}
}
