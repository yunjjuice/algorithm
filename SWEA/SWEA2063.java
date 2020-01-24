import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA2063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] a = new int[T];
         
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
         
        Arrays.sort(a);
                 
        int mid = a.length/2;
 
        System.out.println(a[mid]);
    }
}