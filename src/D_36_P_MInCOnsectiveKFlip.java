import java.util.Scanner;

public class D_36_P_MInCOnsectiveKFlip {
    public static int minFLip(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;
        int ans = 0;

        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {

            if (i >= k) {
                flips = flips ^ isFlipped[i - k];
            }

            int current = arr[i];

            if ((current ^ flips) == 0) {

                if (i + k > n) {
                    return -1;
                }

                ans++;
                flips = flips ^ 1;
                isFlipped[i] = 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=kb.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=kb.nextInt();
        }
        System.out.println("Enter the value of k means size");
        int k=kb.nextInt();
        System.out.println(minFLip(arr, k));
    }
}
