# Activity 2: Testing Account Class

## Objective
Write automated unit test cases in Java to verify that the `Account` class works reliably for both normal operations and edge cases.

---

## Target File to Complete
- `src/com/gdb/tests/TestAccount.java`

---

## Program Summary

### `Account.java`
`Account` is the reusable bank-account model in the `com.gdb.domain` package. It stores the account number, customer name, age, balance, account type, and status. The constructor initializes those six fields. The `deposit` method accepts only positive amounts, and `withdraw` accepts only positive amounts that do not exceed the current balance. The class also provides account information display, getters, and setters. It does not contain a `main` method.

### `TestAccount.java`
`TestAccount` is the executable test program in the `com.gdb.tests` package. It imports `Account`, creates an account with an initial balance of `5000.0`, and checks six behaviors: the initial balance, a valid deposit, a negative deposit, a valid withdrawal, a withdrawal exceeding the balance, and a negative withdrawal. Each check prints `[PASS]` or `[FAIL]`.

The package relationship is:

```text
src/com/gdb/domain/Account.java  ->  package com.gdb.domain;
src/com/gdb/tests/TestAccount.java -> package com.gdb.tests;
									  imports com.gdb.domain.Account;
```

---

## Plain English Step-by-Step Instructions

### Step 1: Test Account Creation & Initial Balance
1. Create a new `Account` object with an initial balance of 5000.0.
2. Check if the balance returned by `getBalance()` equals 5000.0.
3. Print `[PASS]` if it matches, or `[FAIL]` if it does not.

### Step 2: Test Valid Deposit
1. Deposit an amount of 2000.0 into the account.
2. Verify that the method returns `true` and the new balance becomes 7000.0.
3. Print `[PASS]` if both conditions are met, otherwise print `[FAIL]`.

### Step 3: Test Negative Deposit (Edge Case)
1. Attempt to deposit a negative amount (e.g., -500.0).
2. Verify that the method returns `false` and the balance remains unchanged at 7000.0.
3. Print `[PASS]` or `[FAIL]`.

### Step 4: Test Valid Withdrawal
1. Withdraw 3000.0 from the account.
2. Verify that the method returns `true` and the balance decreases to 4000.0.
3. Print `[PASS]` or `[FAIL]`.

### Step 5: Test Withdrawal Exceeding Balance (Edge Case)
1. Attempt to withdraw 10000.0 (which is greater than the available 4000.0).
2. Verify that the method returns `false` and the balance remains 4000.0.
3. Print `[PASS]` or `[FAIL]`.

### Step 6: Test Negative Withdrawal (Edge Case)
1. Attempt to withdraw a negative amount (e.g., -100.0).
2. Verify that the method returns `false` and the balance remains 4000.0.
3. Print `[PASS]` or `[FAIL]`.

---

## How to Compile & Run (Multi-OS Guide)

Run all commands from the `activity2` directory. `Account.java` must be compiled before `TestAccount.java` when compiling files separately, and `bin` must be included in the test classpath.

### Windows (PowerShell)
```powershell
# Move to the Activity 2 directory
Set-Location "C:\Users\Ramesh\Personal Folders\College\SRM\SEMESTERS\SEMESTER - 5\STEP Classes\19th September\SRMfullstack-main\SRMfullstack-main\Solutions\activity2"

# Create the output folder
New-Item -ItemType Directory -Force bin | Out-Null

# Compile both source files together
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })

# Run the test program
java -cp bin com.gdb.tests.TestAccount
```

PowerShell commands for separate compilation:

```powershell
Set-Location "C:\Users\Ramesh\Personal Folders\College\SRM\SEMESTERS\SEMESTER - 5\STEP Classes\19th September\SRMfullstack-main\SRMfullstack-main\Solutions\activity2"
New-Item -ItemType Directory -Force bin | Out-Null
javac -d bin src\com\gdb\domain\Account.java
javac -cp bin -d bin src\com\gdb\tests\TestAccount.java
java -cp bin com.gdb.tests.TestAccount
```

### Windows (Command Prompt - CMD)
```cmd
cd /d "C:\Users\Ramesh\Personal Folders\College\SRM\SEMESTERS\SEMESTER - 5\STEP Classes\19th September\SRMfullstack-main\SRMfullstack-main\Solutions\activity2"
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\*.java src\com\gdb\tests\*.java
java -cp bin com.gdb.tests.TestAccount
```

CMD commands for separate compilation:

```cmd
cd /d "C:\Users\Ramesh\Personal Folders\College\SRM\SEMESTERS\SEMESTER - 5\STEP Classes\19th September\SRMfullstack-main\SRMfullstack-main\Solutions\activity2"
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\Account.java
javac -cp bin -d bin src\com\gdb\tests\TestAccount.java
java -cp bin com.gdb.tests.TestAccount
```

### Linux & macOS (Terminal / Bash / Zsh)
```bash
# Run these commands from the activity2 directory.
mkdir -p bin

# Compile all Java files
find src -name "*.java" -print0 | xargs -0 javac -d bin

# Run the test program
java -cp bin com.gdb.tests.TestAccount
```

Bash commands for separate compilation:

```bash
# Run these commands from the activity2 directory.
mkdir -p bin
javac -d bin src/com/gdb/domain/Account.java
javac -cp bin -d bin src/com/gdb/tests/TestAccount.java
java -cp bin com.gdb.tests.TestAccount
```

---

## Expected Output
```
=== Activity 2: Test Account Suite ===
Test 1 (Initial Balance 5000.0): [PASS]
Test 2  (Deposit 2000.0 -> Assert balance == 7000.0): [PASS]
Test 3 (Deposit -500.0 -> Assert returns false and balance stays 7000.0): [PASS]
Test 4 (Withdraw 3000.0 -> Assert balance == 4000.0): [PASS]
Test 5 (Withdraw 10000.0 -> Assert returns false and balance stays 4000.0): [PASS]
Test 6 (Withdraw -100.0 -> Assert returns false and balance stays 4000.0): [PASS]
=== Complete Activity 2 unit tests and verify output ===
```
