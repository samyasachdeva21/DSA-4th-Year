import java.util.*;

public class Main {

    public static long maxSubarray(long[] nums, long k) {

        // Write your Code Here
        int n = nums.length;
        int K = (int) k;

        if (K > n || K <= 0)
            return 0;

        long sum = 0;

        // Sum of first K elements
        for (int i = 0; i < K; i++) {
            sum += nums[i];
        }

        long max = sum;

        // Sliding window
        for (int i = K; i < n; i++) {
            sum += nums[i] - nums[i - K];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();

        long[] nums = new long[(int) n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        System.out.println(maxSubarray(nums, k));

        sc.close();
    }
}