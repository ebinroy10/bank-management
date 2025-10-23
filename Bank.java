import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;
    private String bankName;
    
    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }
    
    public boolean addAccount(BankAccount account) {
        if (account != null && !accountExists(account.getAccountNumber())) {
            accounts.add(account);
            return true;
        }
        return false;
    }
    
    public boolean accountExists(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    public boolean removeAccount(String accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            accounts.remove(account);
            return true;
        }
        return false;
    }
    
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
    
    public int getTotalAccounts() {
        return accounts.size();
    }
    
    public void displayAllAccounts() {
        System.out.println("Bank: " + bankName);
        System.out.println("Total Accounts: " + getTotalAccounts());
        System.out.println("========================================");
        
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount account : accounts) {
                account.displayAccountInfo();
            }
        }
    }
    
    public String getBankName() {
        return bankName;
    }
}
