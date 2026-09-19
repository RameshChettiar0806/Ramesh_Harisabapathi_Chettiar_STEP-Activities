# Activity 1: Basic Account Class

## Objective
Create a foundational Bank Account class in Java that models real-world account data and basic transactions (deposits and withdrawals).

---

## Target File to Complete
- `src/com/gdb/domain/Account.java`

---

## File Summary

### `Account.java`
`Account` is the domain model for a bank account. It stores the account number, customer name, customer age, balance, account type, and account status in private fields. Its constructor initializes these values, while `deposit` and `withdraw` update the balance only when the transaction is valid. The `displayAccountInfo` method prints the account details, and getters and setters provide controlled access to all six fields. This class does not contain a `main` method, so it is not run directly.

### `TestAccount.java`
`TestAccount` is the test driver in the `com.gdb.tests` package. It imports `com.gdb.domain.Account`, creates an account in its `main` method, displays the account details, tests a successful deposit, tests a successful withdrawal, and tests a withdrawal that exceeds the balance. The printed results show whether each operation succeeded and the balance after each transaction.

---

## Plain English Step-by-Step Instructions

### Step 1: Declare Private Fields
Open `Account.java` and declare 6 private variables to store account details:
1. `accountNumber` (Text / String) - Unique identifier for the account (e.g., "ACC1001").
2. `name` (Text / String) - Full name of the account holder.
3. `age` (Integer / int) - Age of the account holder.
4. `balance` (Decimal / double) - Current money balance in the account.
5. `accountType` (Text / String) - Category of account (e.g., "SAVINGS" or "CURRENT").
6. `status` (Text / String) - Account state (e.g., "ACTIVE" or "INACTIVE").

### Step 2: Create Constructor
Write a public constructor that takes all 6 values as parameters in order and assigns each parameter to its corresponding private field using the `this` keyword.

### Step 3: Implement Deposit Operation
Create a public method named `deposit` that accepts a deposit amount (double) and returns a boolean (true/false):
1. Check if the deposit amount is strictly greater than zero.
2. If valid, add the amount to the current balance and return `true`.
3. If the amount is zero or negative, leave the balance unchanged and return `false`.

### Step 4: Implement Withdrawal Operation
Create a public method named `withdraw` that accepts a withdrawal amount (double) and returns a boolean (true/false):
1. Check if the withdrawal amount is strictly greater than zero AND is less than or equal to the current balance.
2. If valid, subtract the amount from the current balance and return `true`.
3. If the amount is invalid or exceeds the balance, leave the balance unchanged and return `false`.

### Step 5: Implement Account Details Display
Create a public method named `displayAccountInfo` with no return value (void) that prints:
- Account Number
- Customer Name
- Customer Age
- Account Balance
- Account Type
- Account Status

### Step 6: Add Getters and Setters
Write standard getter methods (to retrieve values) and setter methods (to update values) for all 6 private fields.

---

## How to Compile & Run (Multi-OS Guide)

Run these commands from the `activity1` directory. The `TestAccount` class contains the `main` method; `Account` is a model class and should not be run directly.

### Windows (PowerShell)
```powershell
# Create bin folder if not exists
if (!(Test-Path bin)) { New-Item -ItemType Directory -Path bin }

# Compile all source files together
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })

# Run the test program
java -cp bin com.gdb.tests.TestAccount
```

To compile the classes separately, compile `Account.java` first and add the output directory to the test classpath:

```powershell
New-Item -ItemType Directory -Force bin
javac -d bin src\com\gdb\domain\Account.java
javac -cp bin -d bin src\com\gdb\tests\TestAccount.java
java -cp bin com.gdb.tests.TestAccount
```

### Windows (Command Prompt - CMD)
```cmd
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\*.java src\com\gdb\tests\*.java
java -cp bin com.gdb.tests.TestAccount
```

To compile separately:

```cmd
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\Account.java
javac -cp bin -d bin src\com\gdb\tests\TestAccount.java
java -cp bin com.gdb.tests.TestAccount
```

### Linux & macOS (Terminal / Bash / Zsh)
```bash
# Create bin directory
mkdir -p bin

# Compile all Java files
find src -name "*.java" -print0 | xargs -0 javac -d bin

# Run the test program
java -cp bin com.gdb.tests.TestAccount
```

To compile separately:

```bash
mkdir -p bin
javac -d bin src/com/gdb/domain/Account.java
javac -cp bin -d bin src/com/gdb/tests/TestAccount.java
java -cp bin com.gdb.tests.TestAccount
```

---

## Expected Output
```
=== Activity 1: Basic Account Test ===
=========Account Information=========
Account Number: ACC1001
Name of Customer: Rajesh Sharma
Age of Customer: 28
Balance: INR.5000.0
Account Type: SAVINGS
Account Status: ACTIVE
Deposit 2000: SUCCESS | Balance: Rs 7000.0
Withdraw 3000: SUCCESS | Balance: Rs 4000.0
Withdraw 10000 (exceeds balance): FAILED | Balance: Rs 4000.0
```
