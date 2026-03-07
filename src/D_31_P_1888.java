import java.util.Scanner;

public class D_31_P_1888 {

    // Function to compute minimum flips for binary string with rotation
    public int minFlips(String s) {
        int n = s.length();
        int res = n;
        int[] op = {0, 0};

        // Initial mismatch counts for both alternating patterns
        for (int i = 0; i < n; i++)
            op[(s.charAt(i) ^ i) & 1]++;

        // Sliding window to simulate rotation
        for (int i = 0; i < n; i++) {
            // Remove leftmost character contribution
            op[(s.charAt(i) ^ i) & 1]--;
            // Add the rotated character at the end
            op[(s.charAt(i) ^ (n + i)) & 1]++;
            // Update minimum flips
            res = Math.min(res, Math.min(op[0], op[1]));
        }

        return res;
    }

    // Main method with dynamic input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D_31_P_1888 solution = new D_31_P_1888();

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < t; i++) {
            System.out.print("Enter binary string: ");
            String s = sc.nextLine().trim();

            int result = solution.minFlips(s);
            System.out.println("Minimum flips: " + result);
        }

        sc.close();
    }
}
