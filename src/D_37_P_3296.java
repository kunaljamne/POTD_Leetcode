import java.util.Scanner;

public class D_37_P_3296 {

    // Optimized Solution cla
    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;

        long left = 1;
        long right = (long) 1e16; // safely large upper bound
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canFinish(mountainHeight, workerTimes, mid)) {
                answer = mid;      // mid is enough, try smaller
                right = mid - 1;
            } else {
                left = mid + 1;    // mid not enough, try larger
            }
        }

        return answer;
    }

    // Check if workers can finish mountain in 'time' seconds
    private static boolean canFinish(int mountainHeight, int[] workerTimes, long time) {
        long total = 0;

        for (int w : workerTimes) {
            // Contribution formula: max height worker can cut in 'time'
            long maxCut = (long) ((Math.sqrt(1 + 8.0 * time / w) - 1) / 2);
            total += maxCut;

            if (total >= mountainHeight) return true; // early exit
        }

        return total >= mountainHeight;
    }

    // Main method to run example tests
    public static void main(String[] args) {

        // Example 1
        int mountainHeight1 = 4;
        int[] workerTimes1 = {2, 1, 1};
        System.out.println("Minimum seconds: " + minNumberOfSeconds(mountainHeight1, workerTimes1));
        // Output: 3

        // Example 2
        int mountainHeight2 = 99;
        int[] workerTimes2 = {1, 57};
        System.out.println("Minimum seconds: " + minNumberOfSeconds(mountainHeight2, workerTimes2));
        // Output: 3916
    }
}