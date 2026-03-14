import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class D_38_P_1415 {
    static void generate(String current, int n, List<String> list){

         if(current.length() == n){
             list.add(current);
             return;
         }

         char[] chars = {'a','b','c'};

         for(char ch : chars){
             if(current.isEmpty() || current.charAt(current.length()-1) != ch){
                 generate(current + ch, n, list);
             }
         }
     }

     public static String getHappyString(int n, int k) {

         List<String> list = new ArrayList<>();

         generate("", n, list);

         if(list.size() < k) return "";
         // Collections.sort(list);
         return list.get(k-1);
     }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();

        System.out.println(getHappyString(n, k));
    }
}
