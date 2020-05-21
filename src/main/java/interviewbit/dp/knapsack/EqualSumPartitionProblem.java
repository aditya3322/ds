package interviewbit.dp.knapsack;

public class EqualSumPartitionProblem {


    public static  boolean equalSumPartition(int[] arr) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if(sum % 2 != 0) return false;

        return SubsetSumProblem.subsetSumWithTopDown(arr, (sum / 2), arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 11};
        System.out.println(equalSumPartition(arr));
    }
}
