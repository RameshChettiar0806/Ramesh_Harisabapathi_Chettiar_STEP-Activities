# Activity 9: Abstract Classes & Template Method Pattern

## Objective
Refactor the banking hierarchy by creating an abstract base class `AbstractAccount` that enforces common workflows using the Template Method Pattern.

---

## Target Files to Complete
- `src/com/gdb/domain/AbstractAccount.java`
- `src/com/gdb/domain/SavingsAccount.java`
- `src/com/gdb/domain/CurrentAccount.java`
- `src/com/gdb/domain/FixedDepositAccount.java`
- `src/com/gdb/domain/SalaryAccount.java`
- `src/com/gdb/tests/TestAbstractAccount.java`

---

## File Summary

### `AbstractAccount.java`
`AbstractAccount` is the abstract base class that defines the shared banking fields and the common withdrawal workflow. It enforces the template method pattern by implementing the fixed validation sequence in `withdraw(...)` and requiring each subclass to implement its own `processDebit(...)` logic.

### `SavingsAccount.java`
`SavingsAccount` extends `AbstractAccount` and provides the minimum-balance rule for debit operations. It checks whether the withdrawal would fall below the configured limit before subtracting the amount.

### `CurrentAccount.java`
`CurrentAccount` extends `AbstractAccount` and allows debits up to the balance plus the overdraft limit. It implements the subclass-specific debit rule for current accounts and permits balances to move negative as long as the overdraft threshold is respected.

### `FixedDepositAccount.java`
`FixedDepositAccount` extends `AbstractAccount` and blocks premature withdrawal. Its processDebit method always throws `AccountException`, demonstrating how a specialized account can override the common workflow with a stricter rule.

### `SalaryAccount.java`
`SalaryAccount` extends `AbstractAccount` and can be used for salary-specific account behavior. It stores the employer name and inactivity information, while still following the same template-based withdrawal rules used by the other subclasses.

### `TestAbstractAccount.java`
`TestAbstractAccount` is the driver for this activity. It creates instances of the subclasses through the `AbstractAccount` type, performs withdrawals, and verifies that the correct subclass logic runs for each account category.

---

## Plain English Step-by-Step Instructions

### Step 1: Create `AbstractAccount` Base Class
1. Declare `AbstractAccount` as an abstract class.
2. Move all shared fields (`accountNumber`, `name`, `age`, `balance`, `accountType`, `status`, `pin`) into this class.
3. Implement shared concrete methods: `deposit`, `validatePin`, `changePin`, and `displayAccountInfo`.
4. Declare an abstract method `processDebit(double amount)` that returns void and throws `AccountException`.

### Step 2: Implement the Template Method for Withdrawal
In `AbstractAccount`, write the concrete `withdraw` method that enforces the fixed banking sequence:
1. Validate PIN. If invalid, throw `InvalidPinException`.
2. Validate account status. If not active, throw `InactiveAccountException`.
3. Validate amount. If zero or negative, throw `InvalidAmountException`.
4. Call `processDebit(amount)` so each subclass executes its own debit logic.

### Step 3: Implement `processDebit` in Each Subclass
1. `SavingsAccount`: Check minimum balance rule, then deduct amount.
2. `CurrentAccount`: Check overdraft limit rule, then deduct amount.
3. `SalaryAccount`: Check available balance, then deduct amount.
4. `FixedDepositAccount`: Throw exception blocking premature withdrawal.

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
=== Activity 9: Abstract Account & Template Pattern ===
[Savings] Withdraw 2000: SUCCESS | Balance: Rs 8000.0
[Savings] Withdraw below min balance: Caught MinimumBalanceViolationException [PASS]
[Current] Overdraft debit: SUCCESS | Balance: Rs -3000.0
[FixedDeposit] Premature debit: Caught AccountException [PASS]
Template method pattern executed successfully!
```
