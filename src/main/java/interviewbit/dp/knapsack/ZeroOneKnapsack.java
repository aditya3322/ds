package interviewbit.dp.knapsack;

public class ZeroOneKnapsack {

    static int[][] t = new int[5][8];
    static {
        initalization();
    }

    public static void initalization() {
        for(int i = 0;  i < 5; i++ ) {
            for(int j = 0; j < 8; j++) {
                t[i][j] = -1;
            }
        }
    }

    public static int knapsackUsingRecurssion(int[] wt, int[] val, int w, int n) {

        if(n == 0 || w == 0)
            return  0;

        if(wt[n - 1] <= w) {
            return Math.max(
                    val[n - 1] + knapsackUsingRecurssion(wt, val, w - wt[n - 1], n - 1),
                    knapsackUsingRecurssion(wt, val, w, n - 1)
            );
        } else {
            return knapsackUsingRecurssion(wt, val, w, n - 1);
        }
    }

    public static int knapsackWithRecAndMemo(int[] wt, int[] val, int w, int n) {
        if(n == 0 || w == 0) return 0;

        if(t[n - 1][w] != -1) return  t[n - 1][w];

        if(wt[n - 1] <= w) {
            t[n - 1][w] = Math.max(
                    val[n - 1] + knapsackUsingRecurssion(wt, val, w - wt[n - 1], n - 1),
                    knapsackUsingRecurssion(wt, val, w, n - 1)
            );
        } else {
            t[n - 1][w] = knapsackUsingRecurssion(wt, val, w, n - 1);
        }
        return t[n - 1][w];
    }

    public static int knapsackWithTopDown(int[] wt, int[] val, int w, int n) {
        initalization();

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < w + 1; j++) {
                t[i][0] = 0;
                t[0][j] = 0;
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(wt[i - 1] <= j) {
                    t[i][j] = Math.max(
                            val[i - 1] + t[i - 1][j - wt[i - 1]],
                            t[i - 1][j]
                    );
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][w];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4 , 5};
        int[] val = {1, 4, 5, 7};
        int w = 7;
        // knapsack solution using recurrsion
        System.out.println(knapsackUsingRecurssion(wt, val, w, wt.length));
        // knapsack solution using recurrsion and memoization
        System.out.println(knapsackUsingRecurssion(wt, val, w, wt.length));
        //knapsack with top down dp
        System.out.println(knapsackWithTopDown(wt, val, w, wt.length));
    }
}
