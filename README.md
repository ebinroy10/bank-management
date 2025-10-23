# Simple Bank Account Management System

A comprehensive Java-based bank account management system that allows you to manage multiple bank accounts with basic banking operations.

## ???? Features

- ??? **Create New Accounts** - Add new bank accounts with unique account numbers
- ??? **Deposit Money** - Add funds to existing accounts with validation
- ??? **Withdraw Money** - Remove funds with balance checking
- ??? **Check Balance** - View current balance for any account
- ??? **Transfer Money** - Move funds between accounts (atomic operations)
- ??? **View All Accounts** - Display complete list of all accounts
- ??? **Account Information** - Detailed view of specific accounts
- ??? **Remove Accounts** - Delete accounts with confirmation
- ??? **Input Validation** - Comprehensive error handling and validation
- ??? **User-Friendly Interface** - Menu-driven navigation system

## ???? Project Structure

`
BankManagementSystem/
????????? BankAccount.java          # Individual account class
????????? Bank.java                 # Bank management class
????????? BankManagementSystem.java # Main application
????????? README.md                 # This documentation
`

## ???? How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Step-by-Step Instructions

1. **Navigate to the project directory**
   `ash
   cd path/to/BankManagementSystem
   `

2. **Compile the Java files**
   `ash
   javac *.java
   `

3. **Run the application**
   `ash
   java BankManagementSystem
   `

4. **Follow the menu prompts** to perform banking operations

## ???? Menu Options

| Option | Description |
|--------|-------------|
| 1 | Create New Account |
| 2 | Deposit Money |
| 3 | Withdraw Money |
| 4 | Check Balance |
| 5 | Transfer Money |
| 6 | Display All Accounts |
| 7 | Display Account Information |
| 8 | Remove Account |
| 9 | Exit |

## ??????? Class Architecture

### BankAccount Class
- **Purpose**: Represents a single bank account
- **Properties**: 
  - ccountNumber (String)
  - ccountHolderName (String)
  - alance (double)
  - ccountType (String)
- **Methods**:
  - deposit(amount) - Add money to account
  - withdraw(amount) - Remove money from account
  - 	ransfer(targetAccount, amount) - Transfer to another account
  - displayAccountInfo() - Show account details

### Bank Class
- **Purpose**: Manages a collection of bank accounts
- **Properties**:
  - ccounts (List<BankAccount>)
  - ankName (String)
- **Methods**:
  - ddAccount(account) - Add new account
  - emoveAccount(accountNumber) - Remove account
  - indAccount(accountNumber) - Locate specific account
  - displayAllAccounts() - Show all accounts

### BankManagementSystem Class
- **Purpose**: Main application with user interface
- **Features**:
  - Menu-driven interface
  - Input validation
  - Error handling
  - User interaction management

## ???? Usage Examples

### Creating an Account
1. Select option 1 from the menu
2. Enter account number (e.g., "ACC001")
3. Enter holder name (e.g., "John Doe")
4. Enter account type (e.g., "Savings")

### Depositing Money
1. Select option 2 from the menu
2. Enter account number
3. Enter amount to deposit
4. System confirms successful deposit

### Transferring Money
1. Select option 5 from the menu
2. Enter source account number
3. Enter destination account number
4. Enter transfer amount
5. System processes atomic transfer

## ???? Security Features

- **Balance Validation**: Prevents overdrafts
- **Atomic Transfers**: Ensures data consistency
- **Input Validation**: Handles invalid inputs gracefully
- **Account Verification**: Checks account existence before operations

## ???? Account Types Supported

- **Savings Account**: For personal savings
- **Current Account**: For business transactions

## ?????? Important Notes

- Account numbers must be unique
- All monetary amounts are handled as double values
- Withdrawals cannot exceed account balance
- Transfers are atomic operations (either complete or fail)
- The system maintains data integrity throughout operations

## ???? Error Handling

The system includes comprehensive error handling for:
- Invalid account numbers
- Insufficient funds
- Invalid monetary amounts
- Non-existent accounts
- Invalid user inputs

## ???? Technical Details

- **Language**: Java
- **Dependencies**: Standard Java libraries only
- **Data Storage**: In-memory (data lost on program exit)
- **Input Method**: Console-based interface
- **Output Format**: Formatted console output

## ???? Future Enhancements

Potential improvements for the system:
- Database integration for persistent storage
- GUI interface using Java Swing/JavaFX
- Transaction history logging
- Interest calculation for savings accounts
- Multiple currency support
- User authentication system

## ???? Contributing

This is a simple educational project. Feel free to:
- Add new features
- Improve error handling
- Enhance the user interface
- Add unit tests

## ???? License

This project is open source and available for educational purposes.

---

**Happy Banking! ???????**
