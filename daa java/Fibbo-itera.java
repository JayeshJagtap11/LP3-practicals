
 
 import java.util.Scanner;

public class Main{
    public static void solution(int n){
        int num1=0;
        int num2=1;
        int num3;
        if (n<=1){
            System.out.println(n);
            return;
        }
            System.out.println(num1);
            System.out.println(num2);

        for (int i=2;i<n;i++){
            num3=num1+num2;
            System.out.println(num3);
            num1=num2;
            num2=num3;
       
        }
    }
    public static int recursive(int n){
        if (n<=1){
            return n;
        }
        return recursive(n-1)+recursive(n-2);
    }
    public static void main(String[] args){
        System.out.println("Enter the number at which you want fibbonacci series:");
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        System.out.println("number is:"+n);
        // solution(n);
        for(int i=0;i<=n;i++){
            System.out.println(recursive(i));
        }
        
    }
}