import java.util.Scanner;

public class D_35_p_1009 {
    public static int bitwiseComplement(int n) {
        if(n==0 ) return 1;
        int mask = 1;

        while (mask <= n) {
            mask = mask << 1;
        }

        return (mask - 1) ^ n;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n=kb.nextInt();
        System.out.println( bitwiseComplement(n));
    }
}
