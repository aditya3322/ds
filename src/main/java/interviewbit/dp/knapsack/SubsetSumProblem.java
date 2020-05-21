package interviewbit.dp.knapsack;

// check subset exist with sum equals to target
public class SubsetSumProblem {

    public static Boolean[][] t = new Boolean[102][102];
    static {
        t[0][0] = true;
        for(int i = 0; i < 102; i++) {
            t[0][i] = false;
            t[i][0] = true;
        }
    }

    public static boolean subsetSumWitRecursion(int[] arr, int v, int n) {
        if((n  == 0 && v == 0) || v == 0) return true;

        if(n == 0) return false;

        if(arr[n - 1] <= v) {
            return subsetSumWitRecursion(arr, v - arr[n - 1], n - 1) || subsetSumWitRecursion(arr, v, n - 1);
        } else {
            return subsetSumWitRecursion(arr, v, n - 1);
        }
    }

    public static boolean subsetSumWithMemoization(int[] arr, int v, int n) {
        if((n  == 0 && v == 0) || v == 0) return true;

        if(n == 0) return false;

        if(t[n - 1][v] != null) return t[n - 1][v];

        if(arr[n - 1] <= v) {
            t[n - 1][v] = subsetSumWithMemoization(arr, v - arr[n - 1], n - 1)
                                || subsetSumWithMemoization(arr, v - 1, n - 1);
        } else {
            t[n - 1][v] = subsetSumWithMemoization(arr, v - 1, n - 1);
        }
        return t[n - 1][v];
    }

    public static boolean subsetSumWithTopDown(int[] arr, int v, int n) {
        t[0][0] = true;
        for(int i = 0; i < 102; i++) {
            t[0][i] = false;
            t[i][0] = true;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < v + 1; j++) {
                if(arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][v];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9};
        int v = 7;
        // using recursion
        System.out.println(subsetSumWitRecursion(arr, v, arr.length));

        // using recursion + memoization
        System.out.println(subsetSumWitRecursion(arr, v, arr.length));

        // using top down approach
        System.out.println(subsetSumWithTopDown(arr, v, arr.length));
    }
}
