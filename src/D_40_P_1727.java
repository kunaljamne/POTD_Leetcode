import java.util.Scanner;

public class D_40_P_1727 {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int [][]mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=kb.nextInt();
            }
        }

        System.out.println(largestSubmatrix(mat));

    }
        public static int largestSubmatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // Step 1: Build heights (histogram)
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] += matrix[i - 1][j];
                    }
                }
            }

            int maxArea = 0;

            // Step 2: Sort each row and calculate area
            for (int i = 0; i < m; i++) {
                Arrays.sort(matrix[i]); // ascending

                // Traverse from right (largest heights)
                for (int j = n - 1; j >= 0; j--) {
                    int height = matrix[i][j];
                    int width = n - j; // number of columns used
                    maxArea = Math.max(maxArea, height * width);
                }
            }

            return maxArea;
        }
    }

