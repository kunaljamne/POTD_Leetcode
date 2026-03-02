import java.util.Scanner;
public class d_26_P_1536 {

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing = new int[n];

        // Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailing[i] = count;
        }

        int swaps = 0;

        // Greedy row placement
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int j = i;

            while (j < n && trailing[j] < required) {
                j++;
            }

            if (j == n) return -1;

            while (j > i) {
                int temp = trailing[j];
                trailing[j] = trailing[j - 1];
                trailing[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of grid
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        // Read grid elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = minSwaps(grid);
        System.out.println(result);

        sc.close();
    }
}