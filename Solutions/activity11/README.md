# Activity 11: Interface & Factory Pattern

## Objective
Decouple banking operations through the `IAccount` interface and centralize account creation with the Factory Design Pattern.

---

## Target Files to Complete
- `src/com/gdb/domain/IAccount.java`
- `src/com/gdb/domain/AbstractAccount.java`
- `src/com/gdb/domain/AccountFactory.java`
- `src/com/gdb/domain/SavingsAccount.java`
- `src/com/gdb/domain/CurrentAccount.java`
- `src/com/gdb/domain/FixedDepositAccount.java`
- `src/com/gdb/domain/SalaryAccount.java`
- `src/com/gdb/tests/TestInterfaceFactory.java`

---

## File Summary

### `IAccount.java`
`IAccount` defines the common contract for all account types. It includes account information getters, PIN operations, deposits, withdrawals, and account information display.

### `AbstractAccount.java`
`AbstractAccount` implements `IAccount` and provides the shared account state and common banking behavior. It validates account creation data, handles deposits and withdrawals, and delegates account-specific debit rules to subclasses.

### `AccountFactory.java`
`AccountFactory` centralizes account creation in the static `createAccount(...)` method. It selects the correct concrete account class based on the requested type and rejects unknown types with an `IllegalArgumentException`.

### `SavingsAccount.java`
`SavingsAccount` extends `AbstractAccount` and enforces a minimum balance during withdrawals. The factory configures it with a minimum balance of `1000.0` and an interest rate of `4.0`.

### `CurrentAccount.java`
`CurrentAccount` extends `AbstractAccount` and permits withdrawals up to the configured overdraft limit. The factory configures an overdraft limit of `25000.0`.

### `FixedDepositAccount.java`
`FixedDepositAccount` extends `AbstractAccount` and prevents premature withdrawals. The factory creates it with a 12-month tenure and a 6.5% interest rate.

### `SalaryAccount.java`
`SalaryAccount` extends `AbstractAccount` and stores employer information. The factory creates it with `TechCorp` as the employer.

### `TestInterfaceFactory.java`
`TestInterfaceFactory` creates each account type through the `IAccount` interface and verifies that the factory returns the correct account implementation.

---

## Plain English Step-by-Step Instructions

### Step 1: Define the `IAccount` Interface
Create the interface contract for all bank accounts:
1. Add getters for account number, customer name, age, balance, account type, and status.
2. Add `deposit(double amount)` declaring `InvalidAmountException`.
3. Add `withdraw(double amount, String enteredPin)` declaring `AccountException`.
4. Add PIN operations and `displayAccountInfo()`.

### Step 2: Implement the Interface in `AbstractAccount`
1. Make `AbstractAccount` implement `IAccount`.
2. Keep the shared account fields and common methods in the abstract class.
3. Let each concrete account implement its own `processDebit(...)` rule.

### Step 3: Implement the Account Factory
Implement `AccountFactory.createAccount(...)` with a `switch` on the requested type:
1. Return a configured `SavingsAccount` for `SAVINGS`.
2. Return a configured `CurrentAccount` for `CURRENT`.
3. Return a configured `FixedDepositAccount` for `FIXED_DEPOSIT` or `FD`.
4. Return a configured `SalaryAccount` for `SALARY`.
5. Return `null` for a null type and throw `IllegalArgumentException` for an unknown type.

---

## How to Compile & Run (Multi-OS Guide)

### Windows (PowerShell)
```powershell
# Create bin folder if not exists
if (!(Test-Path bin)) { New-Item -ItemType Directory -Path bin }

# Compile all source files
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })

# Run the test program
java -cp bin com.gdb.tests.TestInterfaceFactory
```

### Windows (Command Prompt - CMD)
```cmd
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\*.java src\com\gdb\tests\*.java src\com\gdb\exceptions\*.java
java -cp bin com.gdb.tests.TestInterfaceFactory
```

### Linux & macOS (Terminal / Bash / Zsh)
```bash
# Create bin directory
mkdir -p bin

# Compile all Java files
find src -name "*.java" -print0 | xargs -0 javac -d bin
java -cp bin com.gdb.tests.TestInterfaceFactory
```

---

## Expected Output
```
=== Activity 11: Interface & Factory Pattern Test ===
Factory created: SAVINGS account for Rajesh Sharma
Factory created: CURRENT account for Priya Patel
Factory created: FIXED_DEPOSIT account for Amit Kumar
Factory created: SALARY account for Sneha Verma
All accounts successfully created through AccountFactory!
```
