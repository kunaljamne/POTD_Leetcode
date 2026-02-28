import java.util.Scanner;

public class D_24_P_1680 {
    public static int concatenatedBinary(int n) {
        int MOD = 1000000007;
        long result = 0;
        int length = 0;   // current bit length

        for (int i = 1; i <= n; i++) {

            // check if i is power of 2
            if ((i & (i - 1)) == 0) {
                length++;
            }

            result = ((result << length) + i) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n=kb.nextInt();
//        concatenatedBinary(n);
        System.out.println(concatenatedBinary(n));
        kb.close();
    }
}
