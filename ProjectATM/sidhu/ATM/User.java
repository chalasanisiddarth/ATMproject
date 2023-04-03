package sidhu.ATM;
import java.util.Scanner;
public class User{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Admin a = new Admin();
        System.out.println("Welcome!");
        a.StartATM();
    }
}
