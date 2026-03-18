import java.util.Scanner;
//series is like=1,1,2,3,4,9,8,27.....
///  agar nth term find krna hai if nth term is 6 anser is =9
/// if nth is 5 answer wiill be 4
/// tcs nqt ka previous year questions hian
public class MixtureOfTwoSeriesEvenAndOdd {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        if(n==1 || n==2) System.out.println("1");
        n-=2;
        if(n%2==0){
            int mid=n/2;
            System.out.println((int)Math.pow(3,mid));
        }else{
            int mid=n/2;
            System.out.println((int)Math.pow(2,mid+1));
        }

    }
}
