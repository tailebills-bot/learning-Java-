// baank class
class TaiBank {
    private String firstName;
    private String lastName;
    private double balance;
    private boolean isLoggedIn;

    // Constructor to initialize the account
    public TaiBank(String firstName, String lastName, double initialAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = initialAmount;
        this.isLoggedIn = false; // Accounts start logged out
        System.out.println("Account created for " + firstName + " " + lastName);
    }

    // Login function
    public void login() {
        isLoggedIn = true;
        System.out.println("User " + firstName + " logged in successfully.");
    }

    // Logout function
    public void logout() {
        isLoggedIn = false;
        System.out.println("User logged out.");
    }

    // Add money (Deposit)
    public void deposit(double amount) {
        if (!isLoggedIn) {
            System.out.println("Error: Must be logged in to deposit money.");
            return;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        }
    }

    // Remove money (Withdraw)
    public void withdraw(double amount) {
        if (!isLoggedIn) {
            System.out.println("Error: Must be logged in to withdraw money.");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + " | Remaining Balance: $" + balance);
        } else {
            System.out.println("Error: Insufficient funds or invalid amount.");
        }
    }

    // Change account name
    public void changeName(String newFirstName, String newLastName) {
        if (!isLoggedIn) {
            System.out.println("Error: Must be logged in to change account details.");
            return;
        }
        this.firstName = newFirstName;
        this.lastName = newLastName;
        System.out.println("Name updated to: " + firstName + " " + lastName);
    }

    // Check balance
    public void displayAccountInfo() {
        System.out.println("--- Account Summary ---");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Balance: $" + balance);
        System.out.println("Status: " + (isLoggedIn ? "Logged In" : "Logged Out"));
        System.out.println("-----------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        // 1. Create the account
        TaiBank myAccount = new TaiBank("Tai", "Le", 500.00);

        // 2. Try to deposit while logged out (Should fail)
        myAccount.deposit(100.0);

        // 3. Log in and perform actions
        myAccount.login();
        myAccount.deposit(2500.0);
        myAccount.withdraw(10000.0);
        myAccount.changeName("Not tai", "Le");

        // 4. View final status and log out
        myAccount.displayAccountInfo();
        myAccount.logout();
    }
}