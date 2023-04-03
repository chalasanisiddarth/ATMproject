package sidhu.ATM;
import java.util.*;
public class Admin extends Accounts {
    Scanner sc = new Scanner(System.in);

    void StartATM(){
        System.out.println("ATM Menu:");
        System.out.println("1.Login\n2.Exit");
        int option = sc.nextInt();
        if (option==1){
            LoginAccount();
        }
        else{
            System.out.println("Thank You!");
        }
    }
    
    void LoginMenu(int pin){
        System.out.println("1.Deposit Money\n2.Withdraw Money\n3.Reset pin\n4.Check Account Balance\n5.Logout");
        int input=sc.nextInt();
        if (input==1){
            System.out.println("Enter Amount:");
            float amount=sc.nextFloat();
            Deposit(amount,pin);
        }
        else if (input==2){
            System.out.println("Enter Amount:");
            float amount=sc.nextFloat();
            Withdraw(amount,pin);
        }
        else if (input==3){
            System.out.println("Enter new pin");
            int rpin=sc.nextInt();
            ResetPin(rpin,pin);
        }
        else if (input==4){
            System.out.println("Balance:"+GetBalance(pin)+"\n\n");
            LoginMenu(pin);
        }
        else{
            System.out.println("Thank You!");
            StartATM();
        }

    }
    void LoginAccount(){
        System.out.println("Enter last 4 digits of your debit card no.:");
        int num=sc.nextInt();
        int count=0;
        for (int i=0;i<cards.length;i++){
            if (cards[i]==num){
                count+=1;
                System.out.println("Enter your ATM pin:");
                int pin=sc.nextInt();
                if(pins[i]==pin){
                    System.out.println("Welcome!");
                    LoginMenu(pin);
                }
                else{
                    System.out.println("Incorrect Pin");
                    LoginAccount();
                }
            }
        }
        if (count==0){
            System.out.println("User does not exist.");
        }
    }
    float GetBalance(int pin){
        for(int i=0;i<balances.length;i++){
            if (pins[i]==pin){
                return(balances[i]);
            }
        }
        return 0;
    }
    void Deposit(float amount, int pin){
        for(int i=0;i<pins.length;i++){
            if (pins[i]==pin){
                balances[i]+=amount;
            }
        }
        System.out.println("Closing Balance:"+GetBalance(pin)+"\n\n");
        LoginMenu(pin);
    }
    void Withdraw(float amount, int pin){
        for(int i=0;i<pins.length;i++){
            if(pins[i]==pin){
                if (balances[i]>=amount){
                    balances[i]-=amount;
                    System.out.println("Closing Balance:"+GetBalance(pin)+"\n\n");
                    LoginMenu(pin);
                }
                else{
                    System.out.println("Insufficient funds.");
                    LoginMenu(pin);
                }
            }
        }
        
    }
    void ResetPin(int rpin, int pin){
        for(int i=0;i<pins.length;i++){
            if(pins[i]==pin){
                pins[i]=rpin;

            }
        }
        System.out.println("Pin changed successfully!\n\n");
        LoginAccount();
    } 

    public static void main(String args[]){
    }
}
