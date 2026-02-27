import java.util.Scanner;

public class D_2_ArrayQuesitons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input n and m
        System.out.print("Enter rows (n): ");
        int n = sc.nextInt();

        System.out.print("Enter columns (m): ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        // Input matrix
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // Input x
        System.out.print("Enter target sum (x): ");
        int x = sc.nextInt();

        int result = countSquare(mat, x);

        System.out.println("Number of square submatrices with sum " + x + " = " + result);

        sc.close();
    }

    public static int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] prefix = new int[n][m];

        // Build prefix sum matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] = mat[i][j];

                if (i > 0)
                    prefix[i][j] += prefix[i - 1][j];

                if (j > 0)
                    prefix[i][j] += prefix[i][j - 1];

                if (i > 0 && j > 0)
                    prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        int count = 0;

        // Check all square sizes
        for (int size = 1; size <= Math.min(n, m); size++) {
            for (int i = 0; i + size - 1 < n; i++) {
                for (int j = 0; j + size - 1 < m; j++) {

                    int r = i + size - 1;
                    int c = j + size - 1;

                    int sum = prefix[r][c];

                    if (i > 0)
                        sum -= prefix[i - 1][c];

                    if (j > 0)
                        sum -= prefix[r][j - 1];

                    if (i > 0 && j > 0)
                        sum += prefix[i - 1][j - 1];

                    if (sum == x)
                        count++;
                }
            }
        }

        return count;
    }
}