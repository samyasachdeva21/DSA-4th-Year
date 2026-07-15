import java.util.*;

public class PossibleStrings {

    static class Solution {

        public List<String> AllPossibleStrings(String s) {
            List<String> ans = new ArrayList<>();

            generate(s, 0, "", ans);

            Collections.sort(ans);
            return ans;
        }

        private void generate(String s, int idx, String curr, List<String> ans) {

            if (idx == s.length()) {
                if (!curr.isEmpty()) {
                    ans.add(curr);
                }
                return;
            }

            // Don't include current character
            generate(s, idx + 1, curr, ans);

            // Include current character
            generate(s, idx + 1, curr + s.charAt(idx), ans);
        }
    }

    public static void main(String[] args) {

        // Change this string to test different inputs
        String s = "abc";

        Solution sol = new Solution();
        List<String> result = sol.AllPossibleStrings(s);

        System.out.println("Input: " + s);
        System.out.println("All Possible Non-Empty Subsequences:");

        for (String str : result) {
            System.out.println(str);
        }
    }
}