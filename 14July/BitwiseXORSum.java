import java.util.*;

public class BitwiseXORSum {

    public static List<Integer> specialXor(int N, int Q, int[] A, int[][] query) {

        int xor = 0;
        for (int x : A)
            xor ^= x;

        int[] pre = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pre[i] = pre[i - 1] ^ A[i - 1];
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < Q; i++) {
            int l = query[i][0];
            int r = query[i][1];

            int inside = pre[r] ^ pre[l - 1];
            ans.add(xor ^ inside);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[][] query = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }

        List<Integer> ans = specialXor(N, Q, A, query);

        for (int x : ans) {
            System.out.println(x);
        }

        sc.close();
    }
}