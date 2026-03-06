import java.util.Scanner;

public class Day_30_p_1784LC {

    public static boolean checkOnesSegment(String s) {
        boolean flag = true; // true → 1-segment chal raha hai ya start ke liye ready

        for (int i = 1; i < s.length(); i++) {
            int val = s.charAt(i) - '0';

            if (val == 0 && flag) {
                // End of first 1-segment
                flag = false;
            }

            if (val == 1 && !flag) {
                // 1 appears after 0 → invalid
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= t; i++) {
            System.out.println("Enter binary string for test case " + i + ":");
            String input = sc.nextLine();
            boolean result = checkOnesSegment(input);
            System.out.println("Output: " + result);
        }

        sc.close();
    }
}