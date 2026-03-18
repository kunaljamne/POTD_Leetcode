import java.util.Scanner;

public class D_41_P_3070 {

    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = grid[i][j];

                if (i > 0) {
                    prefix[i][j] += prefix[i - 1][j];
                }
                if (j > 0) {
                    prefix[i][j] += prefix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                }

                if (prefix[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int k=kb.nextInt();
        int[][] grid=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j]=kb.nextInt();
            }
        }
        System.out.println(countSubmatrices(grid, k));
    }
}