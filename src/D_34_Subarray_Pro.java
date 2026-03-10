import java.util.*;

public class D_34_Subarray_Pro {

    public static int countSubarrays(int[] arr) {
        int n = arr.length;
        long ans = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans += i - idx;
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int idx = st.pop();
            ans += n - idx;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = countSubarrays(arr);
        System.out.println(result);

        sc.close();
    }
}