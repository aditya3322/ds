package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColourfulNumber {

    public int colorful(int A) {
        String number = String.valueOf(A);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= number.length(); i++) {
            for(int j = 0; j < number.length(); j++) {
                if((j + i) > number.length()) continue;
                String str = number.substring(j, (j + i));
                if(map.containsKey(str)) {
                    return 0;
                } else {
                    int product = 1;
                    for (char chr: str.toCharArray()) {
                       product *= ((int)chr - 48);
                    }
                    map.put(str, product);
                }
            }
        }
       // System.out.println(map);
        List<Integer> values = new ArrayList<>(map.values());
        for(int i = 0; i < values.size(); i++) {
            for(int j = i + 1; j < values.size(); j++) {
                if(values.get(i).equals(values.get(j))) return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ColourfulNumber().colorful(3245));
    }
}
