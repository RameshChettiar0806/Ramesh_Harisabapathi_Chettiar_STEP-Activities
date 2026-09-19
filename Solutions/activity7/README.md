# Activity 7: Account Subclasses (Inheritance)

## Objective
Apply Object-Oriented Inheritance by creating specialized bank account subclasses: `SavingsAccount`, `CurrentAccount`, `FixedDepositAccount`, and `SalaryAccount` extending `Account`.

---

## Target Files to Complete
- `src/com/gdb/domain/Account.java`
- `src/com/gdb/domain/SavingsAccount.java`
- `src/com/gdb/domain/CurrentAccount.java`
- `src/com/gdb/domain/FixedDepositAccount.java`
- `src/com/gdb/domain/SalaryAccount.java`
- `src/com/gdb/tests/TestAccountSubclasses.java`

---

## File Summary

### `Account.java`
`Account` is the base class for all banking account types in this activity. It holds the common fields such as account number, name, age, balance, account type, status, and PIN. It also provides the core account rules including validation, deposit, withdrawal, and display logic that all subclasses inherit.

### `SavingsAccount.java`
`SavingsAccount` extends `Account` and adds account-specific behavior such as a minimum balance and an interest rate. It calls the parent constructor with the account type `SAVINGS`, stores the custom properties, and includes a method to apply interest to the balance.

### `CurrentAccount.java`
`CurrentAccount` builds on `Account` by adding an overdraft limit for business-style transactions. It stores the overdraft amount in a field, exposes it through getters and setters, and uses the account type `CURRENT` when initialized.

### `FixedDepositAccount.java`
`FixedDepositAccount` extends `Account` and includes a fixed tenure period and interest rate. It calculates maturity value using a compound-interest formula based on the balance, tenure, and rate, making it a specialized long-term investment account.

### `SalaryAccount.java`
`SalaryAccount` extends `Account` and tracks the employer name and inactivity duration. It is designed for salaried accounts and includes accessors for the employer and the months of inactivity, which can be useful in later banking activities.

### `TestAccountSubclasses.java`
`TestAccountSubclasses` is the activity driver that instantiates each subclass, prints its key fields, and confirms that the inheritance model works as expected. It verifies that each specialized account is created with the correct type-specific information.

---

## Plain English Step-by-Step Instructions

### Step 1: Create `SavingsAccount`
1. Make `SavingsAccount` extend `Account`.
2. Add private fields: `minBalance` (e.g., 1000.0) and `interestRate` (e.g., 4.0%).
3. In constructor, call `super(...)` passing `"SAVINGS"` as the account type.
4. Implement `applyInterest()`: calculates interest based on the rate and adds it to the balance.

### Step 2: Create `CurrentAccount`
1. Make `CurrentAccount` extend `Account`.
2. Add private field: `overdraftLimit` (e.g., 25000.0).
3. In constructor, call `super(...)` passing `"CURRENT"` as the account type.
4. Add getter and setter for `overdraftLimit`.

### Step 3: Create `FixedDepositAccount`
1. Make `FixedDepositAccount` extend `Account`.
2. Add private fields: `tenureMonths` (e.g., 12) and `interestRate` (e.g., 6.5%).
3. In constructor, call `super(...)` passing `"FIXED_DEPOSIT"`.
4. Implement `calculateMaturityAmount()`: calculates compound interest based on tenure and rate.

### Step 4: Create `SalaryAccount`
1. Make `SalaryAccount` extend `Account`.
2. Add private fields: `employerName` and `inactiveMonths`.
3. In constructor, call `super(...)` passing `"SALARY"`.

---

## How to Compile & Run (Multi-OS Guide)

> [!NOTE]
> Before running the tests, open `src/com/gdb/tests/TestAccountSubclasses.java` and uncomment the test calls inside the `main` method once you have finished all four subclasses.

### Windows (PowerShell)
```powershell
# Create bin folder if not exists
if (!(Test-Path bin)) { New-Item -ItemType Directory -Path bin }

# Compile all source files
javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName

# Run the test program
java -cp bin com.gdb.tests.TestAccountSubclasses
```

### Windows (Command Prompt - CMD)
```cmd
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\*.java src\com\gdb\tests\*.java src\com\gdb\exceptions\*.java
java -cp bin com.gdb.tests.TestAccountSubclasses
```

### Linux & macOS (Terminal / Bash / Zsh)
```bash
# Create bin directory
mkdir -p bin

# Compile all Java files
find src -name "*.java" -print0 | xargs -0 javac -d bin

# Run the test program
java -cp bin com.gdb.tests.TestAccountSubclasses
```

---

## Expected Output
```
=== Activity 7: Account Subclasses Test ===
Savings Account Created: Balance Rs 10000.0 | Min Balance: Rs 1000.0
Current Account Created: Overdraft Limit Rs 25000.0
Fixed Deposit Created: Tenure 12 months | Interest: 6.5%
Salary Account Created: Employer Infosys
All subclasses instantiated successfully!
```
