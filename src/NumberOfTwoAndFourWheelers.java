import java.util.Scanner;

public class NumberOfTwoAndFourWheelers {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int vehicle=kb.nextInt();
        int wheeler=kb.nextInt();

        if(vehicle==wheeler ||vehicle==0 || wheeler==0 || wheeler%2!=0 || vehicle*2>wheeler || vehicle*4<wheeler){
            System.out.println("-1");
            return ;
        }
        int fw=(wheeler-2*vehicle)/2;
        int tw=vehicle-fw;

        System.out.println("Four Wheelers is: "+fw+"Two wheeler is: "+tw);


    }
}
