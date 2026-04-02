import java.util.Scanner;

class BankAccount {

    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%
    String[] transacHistory;
    int idx;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.dividendRate = 0.0;
        this.transacHistory=new String[90];
        this.idx =0;
    }

    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        transacHistory[idx]="Deposit..."+amount;
        idx++;
        // too simple - need refinement
    }

    // Withdraw money
    public void withdraw(double amount) {
        balance = balance - amount;
        transacHistory[idx]="Withdraw..."+amount;
        idx++;
        // too simple - need refinement
    }

    // Calculate dividend
    public double calculateDividend() {
        return balance * dividendRate;
    }

    // Apply dividend to balance
    public void applyDividend() {
        double dividend = calculateDividend();
        balance = balance + dividend;
        transacHistory[idx]="Add Dividend..."+dividend;
        idx++;
    }

    public void printTransAct(){
        System.out.println("Transaction History...");
        for (int i=0;i<idx;i++){
            System.out.println(transacHistory[i]);
        }
    }
    // Set dividend rate
    public void setDividendRate(double rate) {
        dividendRate = rate;
        // too simple - need refinement
    }

    // Display account information
    public void printObjectState() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Name          : " + name);
        System.out.println("Balance       : RM " + balance);
        System.out.println("Dividend Rate : " + dividendRate * 100 + "%");
        System.out.println();
    }

    public double getBalance(){
        return this.balance;
    }
}

public class App {
    public static void main(String[] args) {

        int[] finMarks= {88,75,60,80,90,95,77,91,77,80};
        for (int elem:finMarks){
            System.out.println(elem);
        }


        Scanner sc = new Scanner(System.in);

        BankAccount acc1= new BankAccount("Ali",10.00);
        BankAccount acc2= new BankAccount("Bali",10.00);
        BankAccount acc3= new BankAccount("Cali",10.00);
        BankAccount acc4= new BankAccount("Abudali",10.00);
        BankAccount acc5= new BankAccount("Dali",10.00);

        System.out.println(acc1);

        acc3.deposit(575);
        acc3.setDividendRate(0.125);
        acc3.applyDividend();
        acc3.printObjectState();

        BankAccount[] ACCArray = new BankAccount[7];
        System.out.println(ACCArray);
        System.out.println(ACCArray[0]);
        System.out.println(ACCArray[1]);
        System.out.println(ACCArray[2]);
        System.out.println(ACCArray[3]);
        System.out.println(ACCArray[4]);

        ACCArray[0]=acc1;
        ACCArray[1]=acc2;
        ACCArray[2]=acc3;
        ACCArray[3] = new BankAccount("Siti", 500);
        ACCArray[4] = new BankAccount("Siva", 100);
        ACCArray[5] = acc4;
        ACCArray[6] = acc5;

        ACCArray[3].deposit(700);
        ACCArray[4].withdraw(50);
        ACCArray[4].deposit(400);
        ACCArray[4].withdraw(200);

        for (int i=0;i<7;i++){
            ACCArray[i].printObjectState();
        }

        //end of year 2026, apply div 7.5% to all acc
        for (int i=0;i<7;i++){
            ACCArray[i].setDividendRate(0.075);
            ACCArray[i].applyDividend();
            ACCArray[i].printObjectState();
        }

        //search for account w highest balance,then printinfo
        BankAccount temp = ACCArray[0]; //using enhanced loop
        for (BankAccount elem:ACCArray){
            if (elem.getBalance()>temp.getBalance()){
                temp=elem;
            }           
        }
        System.out.println("Account with highest balance...");
        temp.printObjectState();

        ACCArray[4].printTransAct();
        
        /*System.out.println("===== BANK ACCOUNT SYSTEM =====");

        // Input
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: RM ");
        double initialDeposit = sc.nextDouble();

        // Create account
        BankAccount acc1 = new BankAccount(name, initialDeposit);

        System.out.println("\nAccount created successfully.");
        acc1.printObjectState();

        // Deposit
        System.out.println("----- DEPOSIT -----");
        System.out.print("Enter deposit amount: RM ");
        double depositAmount = sc.nextDouble();
        acc1.deposit(depositAmount);
        acc1.printObjectState();

        // Withdraw
        System.out.println("----- WITHDRAW -----");
        System.out.print("Enter withdrawal amount: RM ");
        double withdrawAmount = sc.nextDouble();
        acc1.withdraw(withdrawAmount);
        acc1.printObjectState();

        // Dividend
        System.out.println("----- YEAR-END DIVIDEND -----");
        System.out.print("Enter dividend rate (example 0.05 for 5%): ");
        double rate = sc.nextDouble();
        acc1.setDividendRate(rate);
        acc1.applyDividend();

        acc1.printObjectState();

        System.out.println("===== END OF PROGRAM ====="); */

        sc.close();
    }
}

/*
 * import java.util.Scanner;
 * 
 * class BankAccount {
 * 
 * String name;
 * double balance;
 * double dividentRate; // e.g. 0.03 = 3%
 * 
 * // Constructor
 * public BankAccount(String name, double initDeposit) {
 * this.name = name;
 * this.balance = initDeposit;
 * }
 * 
 * // Deposit money
 * public void deposit(double amount) {
 * balance = balance + amount;
 * }
 * 
 * // Withdraw money
 * public void withdraw(double amount) {
 * balance = balance - amount;
 * }
 * 
 * // Calculate divident
 * public double calculateDivident() {
 * return balance * dividentRate;
 * }
 * 
 * // Add divident into balance
 * public void applyDivident() {
 * double divident = calculateDivident();
 * balance += divident;
 * }
 * 
 * public void setDividentRate(double theRate) {
 * this.dividentRate = theRate;
 * }
 * 
 * // Display account info
 * public String printObjState() {
 * return "===== ACCOUNT INFO ===== \n" +
 * "Name          : " + name +
 * "Balance       : RM " + balance +
 * "Divident Rate : " + dividentRate * 100;
 * }
 * }
 * 
 * public class App {
 * public static void main(String[] args) throws Exception {
 * System.out.println("Hello, World!");
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("CREATING NEW BANK ACCOUNT");
 * System.out.print("Enter account holder name: ");
 * String name = sc.nextLine();
 * 
 * System.out.println("Enter initial deposit: ");
 * double initialDeposit = sc.nextDouble();
 * 
 * // Create account
 * BankAccount acc1 = new BankAccount(name, initialDeposit);
 * System.out.println("Acc Successfully created...initial deposit=RM" +
 * initialDeposit);
 * acc1.printObjState();
 * // Perform operations
 * System.out.println("\n--- PERFORMING TRANSACTIONS ---");
 * System.out.println("Enter amount Deposit RM...");
 * double depo = sc.nextDouble();
 * acc1.deposit(depo);
 * System.out.println(acc1.printObjState());
 * System.out.println("Enter amount Withdraw RM...");
 * double wd = sc.nextDouble();
 * acc1.withdraw(wd);
 * acc1.printObjState();
 * System.out.
 * println("\n\n\nEND OF 2026 - CALC DIVIDENT AT END OF FINANTIAL YEAR");
 * System.out.println("Enter div rate (ie 0.5 for 5%");
 * double theRate = sc.nextDouble();
 * acc1.setDividentRate(theRate);
 * acc1.applyDivident();
 * 
 * // Final output
 * acc1.printObjState();
 * 
 * sc.close();
 * }
 * }
 */