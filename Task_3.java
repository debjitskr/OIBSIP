import java.util.*;
class ATM {
    String name;
    String acct_no;
    String uid;
    String pin;
    float balance = 1000;
    int transaction = 0;
    String tran_his = " ";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Account no. - ");
        this.acct_no = sc.nextLine();
        System.out.print("\nEnter Your User Id - ");
        this.uid = sc.nextLine();
        System.out.print("\nEnter Your Pin - ");
        this.pin = sc.nextLine();
        System.out.println("\nSuccessfully Registered.\nNow Login");
    }

    public boolean chk_login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nUser ID - ");
            String userid = sc.nextLine();
            if (userid.equals(uid)) {
                while (!isLogin) {
                    System.out.print("\nEnter Pin - ");
                    String Pin = sc.nextLine();
                    if (Pin.equals(pin)) {
                        System.out.println("\n\tLOGGED IN,");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Pin");
                    }
                }
            } else {
                System.out.println("\nIncorrect userid");
            }
        }
        return true;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the amount to Withdraw");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            transaction++;
            balance -= amount;
            System.out.println("\nMoney Withdrawn");
            String str = "\nRs." + amount + " Withdrawn";
            tran_his = tran_his.concat(str);
        } else {
            System.out.println("\nInsufficient balance");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the amount to Deposit");
        float amount = sc.nextFloat();
        transaction++;
        balance += amount;
        System.out.println("\nMoney Deposited.");
        String str = "\nRs." + amount + " Deposited";
        tran_his = tran_his.concat(str);
    }

    public void Transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Recipient's name: ");
        String recipient = sc.nextLine();
        System.out.println("Enter the amount to Transfer");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            transaction++;
            balance -= amount;
            System.out.println("\nMoney Transferred to " + recipient);
            String str = "\nRs." + amount + " Transferred to " + recipient + " ";
            tran_his = tran_his.concat(str);
        } else {
            System.out.println("\nUnable to transfer money. Insufficient balance");
        }
    }

    public void disp_balance() {
        System.out.println("Available balance: Rs." + balance);
    }

    public void Transaction_history() {
        if (transaction == 0)
            System.out.println("\nNo Transactions");
        else
            System.out.println(" "+ tran_his);
    }
}

public class Task_3 {
    public static void main(String[] args) {
        ATM ob = new ATM();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t*****\tWELCOME TO ATM\t*****\t");
        System.out.println("\nPlease register first.");
        ob.register();
        if (ob.chk_login()) {
            System.out.print("\tHAPPY BANKING | Mr." +ob.name+"\n");
            while (true) {

                System.out.println("\n1.Transaction History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Balance\n6.Exit");
                System.out.println("Enter you choice: ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1 -> ob.Transaction_history();
                    case 2 -> ob.withdraw();
                    case 3 -> ob.deposit();
                    case 4 -> ob.Transfer();
                    case 5 -> ob.disp_balance();
                    case 6 -> {
                        System.out.println("\nThank you for using our ATM. Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("\nInvalid choice. Please select a valid option.");
                }
            }
        } else {
            System.out.println("\nLogin failed. Exiting...");
            System.exit(0);
        }
    }
}
