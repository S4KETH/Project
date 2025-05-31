import java.util.Scanner;
public class bankapp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOperations bo = new BankOperations();

        while (true) {
            System.out.println("\nBank Menu:");
            System.out.println("1. Create an Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit money");
            System.out.println("4. WithDraw money");
            System.out.println("5. DeleteAccount");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Initial Balance is: ");
                    double balance = sc.nextDouble();
                    bo.createAccount(name, balance);
                    break;
                case 2:
                    bo.viewAccounts();
                    break;
                case 3:
                    System.out.println("Enter your id: ");
                    int depid = sc.nextInt();
                    System.out.println("Enter deposit amount: ");
                    double depam = sc.nextDouble();
                    bo.deposit(depid,depam);
                    break;
                case 4:
                System.out.println("Enter your id: ");
                int withid = sc.nextInt();
                System.out.println("Enter withdraw amount: ");
                double witham = sc.nextDouble();
                bo.withdraw(withid,witham);
                break;
                case 5:
                System.out.println("Enter id: ");
                int delid = sc.nextInt();
                bo.deleteAccount(delid);
                break;
                case 6:
                System.out.println("Logged out..");
                System.exit(0);
                default:
                System.out.println("Invalid choice/Input");
            }
        }
    }
}
