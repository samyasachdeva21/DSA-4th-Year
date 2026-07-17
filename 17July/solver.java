import java.util.*;

public class Main {

    static class Solution {

        public List<Integer> solve(int N, int[] arr, int target) {

            List<Integer> ans = new ArrayList<>();

            int left = 0, sum = 0;

            for (int right = 0; right < N; right++) {
                sum += arr[right];

                while (sum > target && left <= right) {
                    sum -= arr[left++];
                }

                if (sum == target) {
                    ans.add(left + 1);   // 1-based index
                    ans.add(right + 1);  // 1-based index
                    return ans;
                }
            }

            ans.add(-1);
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        List<Integer> result = obj.solve(N, arr, target);

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}