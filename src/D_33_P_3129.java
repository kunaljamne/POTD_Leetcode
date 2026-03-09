import java.util.Scanner;

public class D_33_P_3129 {

    int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: sequences consisting of only zeros or only ones
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                // End with 0: last segment of zeros (length k)
                for (int k = 1; k <= limit && i - k >= 0; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - k][j][1]) % MOD;
                }

                // End with 1: last segment of ones (length k)
                for (int k = 1; k <= limit && j - k >= 0; k++) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j - k][0]) % MOD;
                }
            }
        }

        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }

    // Main method to test
    public static void main(String[] args) {
        D_33_P_3129 solver = new D_33_P_3129();

        int zero1 = 3, one1 = 2, limit1 = 2;
        int zero2 = 2, one2 = 3, limit2 = 1;

        System.out.println("Test Case 1: " + solver.numberOfStableArrays(zero1, one1, limit1));
        System.out.println("Test Case 2: " + solver.numberOfStableArrays(zero2, one2, limit2));
    }
}