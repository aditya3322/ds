package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {

    public int isValidSudoku(final List<String> A) {
        HashSet<String> rowwise = new HashSet<>();
        HashSet<String> colwise = new HashSet<>();
        HashSet<String> boxwise = new HashSet<>();

        for(int i = 0; i < A.size(); i++) {
            char[] row = A.get(i).toCharArray();
            for(int j = 0; j < row.length; j++) {
                if(row[j] != '.') {
                    int value = row[j] - 48;
                    String rowKey = (i + "_" + value);
                    String colKey = (j + "_" + value);
                    String boxKey = (i/3 + "_" + j/3 + "_" + value);
                    if(rowwise.contains(rowKey)) return 0;
                    if(colwise.contains(colKey)) return 0;
                    if(boxwise.contains(boxKey)) return 0;

                    rowwise.add(rowKey);
                    colwise.add(colKey);
                    boxwise.add(boxKey);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(new String[]{
                "..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", "........."
        }));
        new ValidSudoku().isValidSudoku(list);
    }
}
