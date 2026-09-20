# Activity 10: Banking Operations with Abstract Accounts

## Objective
Build a transaction engine to manage collections of abstract accounts, execute secure fund transfers between accounts, and process monthly banking cycles using the abstract account hierarchy.

---

## Target Files to Complete
- `src/com/gdb/domain/AbstractAccount.java`
- `src/com/gdb/domain/SavingsAccount.java`
- `src/com/gdb/domain/CurrentAccount.java`
- `src/com/gdb/domain/FixedDepositAccount.java`
- `src/com/gdb/domain/SalaryAccount.java`
- `src/com/gdb/exceptions/AccountException.java`
- `src/com/gdb/exceptions/InvalidPinException.java`
- `src/com/gdb/exceptions/BankingException.java`
- `src/com/gdb/tests/TestAbstractAccount.java`

---

## File Summary

### `AbstractAccount.java`
`AbstractAccount` is the shared parent class for the banking system. It defines the common account data and implements the standard validation logic for deposits, withdrawals, and PIN checks. It also declares the transfer operation that uses withdrawal followed by deposit, so the same rules apply across all account types.

### `SavingsAccount.java`
`SavingsAccount` extends `AbstractAccount` and enforces the minimum-balance rule during debit operations. It also provides the interest calculation method used for the monthly bank cycle.

### `CurrentAccount.java`
`CurrentAccount` extends `AbstractAccount` and supports withdrawals up to the available balance plus the overdraft limit. This allows a current account to go into a negative balance as long as it remains within its allowed overdraft.

### `FixedDepositAccount.java`
`FixedDepositAccount` extends `AbstractAccount` and blocks premature withdrawals. Its debit rule always throws an `AccountException`, ensuring fixed deposits cannot be accessed before maturity.

### `SalaryAccount.java`
`SalaryAccount` extends `AbstractAccount` and stores employer details and inactivity tracking information. It follows the same transaction rules as the other accounts but retains salary-specific metadata.

### `AccountException.java`
`AccountException` is the root exception for the banking domain. All account-related errors, including invalid PINs, insufficient funds, and inactive accounts, inherit from it.

### `InvalidPinException.java`
`InvalidPinException` is thrown when the supplied PIN does not match the stored PIN. It is used to secure transfers and withdrawals.

### `BankingException.java`
`BankingException` is used for transfer-level errors, such as invalid destination accounts or attempts to transfer to the same account. It ensures the transfer engine handles invalid operations cleanly.

### `TestAbstractAccount.java`
`TestAbstractAccount` is the driver for this activity. It creates a portfolio of account objects, tests a valid transfer, checks invalid PIN handling, and processes the monthly interest cycle for savings accounts.

---

## Plain English Step-by-Step Instructions

### Step 1: Create the Account Portfolio
1. Create multiple `AbstractAccount` references using different account types such as `SavingsAccount`, `CurrentAccount`, and `SalaryAccount`.
2. Store them in an array so the same processing logic can be applied to each account.

### Step 2: Implement Secure Fund Transfer
In `AbstractAccount`, write a `transfer(...)` method that:
1. Validates the destination account is not null and not the same as the source.
2. Calls `withdraw(amount, enteredPin)` on the source account.
3. If the withdrawal succeeds, calls `deposit(amount)` on the destination account.
4. If the withdrawal fails, ensure the destination account is not credited and propagate the error.

### Step 3: Validate Wrong-PIN Behavior
1. Attempt a transfer with an incorrect PIN.
2. Catch `InvalidPinException` or a general `AccountException`.
3. Verify that neither source nor destination balances change after the failed transfer.

### Step 4: Process Monthly Banking Cycle
1. Loop through all accounts in the portfolio.
2. If an account is a `SavingsAccount`, apply the interest using `applyInterest()`.
3. If an account is a `SalaryAccount`, check the inactivity or salary-processing condition as required by the activity.

---

## How to Compile & Run (Multi-OS Guide)

### Windows (PowerShell)
```powershell
# Create bin folder if not exists
if (!(Test-Path bin)) { New-Item -ItemType Directory -Path bin }

# Compile all source files
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })

# Run the test program
java -cp bin com.gdb.tests.TestAbstractAccount
```

### Windows (Command Prompt - CMD)
```cmd
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\*.java src\com\gdb\tests\*.java src\com\gdb\exceptions\*.java
java -cp bin com.gdb.tests.TestAbstractAccount
```

### Linux & macOS (Terminal / Bash / Zsh)
```bash
# Create bin directory
mkdir -p bin

# Compile all Java files
find src -name "*.java" -print0 | xargs -0 javac -d bin

# Run the test program
java -cp bin com.gdb.tests.TestAbstractAccount
```

---

## Expected Output
```
=== Activity 10: Banking Operations Suite ===
Transfer successful: Rs.1000.0 from Savings to Current
Test 3: [PASS], Invalid PIN Entered: Invalid PIN Entered
Monthly Interest Cycle processed for all qualifying accounts.
All banking operations passed!
=== Complete the test suite and verify all banking operations ===
```
