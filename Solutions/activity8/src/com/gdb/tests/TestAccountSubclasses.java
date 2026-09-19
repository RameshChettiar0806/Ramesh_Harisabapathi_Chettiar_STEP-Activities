package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestAccountSubclasses {
    public static void main(String[] args) {
        System.out.println("=== Activity 8: Polymorphism Test ===");

        // NOTE: The domain classes in src/com/gdb/domain are provided complete (the Activity 7 subclasses plus
        // their overridden withdraw() methods). Declare each account with the parent type Account so that the
        // overridden withdraw() is chosen at runtime (dynamic method dispatch).
        
        System.out.println("=== Complete Activity 8 polymorphism tests and verify output ===");

        // TODO: Step 1 - Test SavingsAccount minimum balance breach
        //   Create a SavingsAccount (balance 10000.0, minBalance 1000.0), withdraw 9500.0 with the correct PIN,
        //   catch MinimumBalanceViolationException and print [PASS]; print [FAIL] for any other outcome.
        Account s1 = new SavingsAccount("SA01", "RAMESH", 20, 10000.0, "ACTIVE", "1234", 1000.0, 5.0);
        try{
            s1.withdraw(9500.0, "1234");
        }catch(MinimumBalanceViolationException e){
            System.out.println("Test 1: [PASS], Minimum Balance: " + e.getMessage());
        }catch(AccountException e){
            System.out.println("Test 1: [FAIL], " + e.getMessage());
        }
        // TODO: Step 2 - Test CurrentAccount valid withdrawal utilizing overdraft facility
        //   Create a CurrentAccount (balance 5000.0, overdraftLimit 25000.0), withdraw 10000.0 with the correct PIN,
        Account s2 = new CurrentAccount("CA02", "Ramesh", 20, 5000.0, "ACTIVE", "5678", 25000.0);
        //   verify it succeeds (balance goes to -5000.0) and print [PASS].
        try{
            s2.withdraw(10000.0, "5678");
            System.out.println("Test 2: [PASS], Attempted to withdraw more amount than balance.");
        }catch(Exception e){
            System.out.println("Test 3: [FAIL], " + e.getMessage());
        }
        // TODO: Step 3 - Test CurrentAccount exceeding overdraft limit
        //   On the same account, withdraw 30000.0, catch InsufficientBalanceException and print [PASS].
        Account s3 = new CurrentAccount("CA03", "Ramesh Chettiar", 20, 5000.0, "ACTIVE", "1092", 25000.0);
        try{
            s3.withdraw(30001.0,"1092");
        }catch(InsufficientBalanceException e){
            System.out.println("Test 3: [PASS], Exceeded Overdraft Limit: " + e.getMessage());
        }catch(AccountException e){
            System.out.println("Test 3: [FAIL], " + e.getMessage());
        }
        // TODO: Step 4 - Test FixedDepositAccount premature withdrawal block
        //   Create a FixedDepositAccount, attempt any withdrawal, catch AccountException and print [PASS].
        Account s4 = new FixedDepositAccount("FDA05", "Ramesh Harisabapathi Chettiar", 20, 5000.0, "ACTIVE", "6789", 24, 5.0);
        try{
            s4.withdraw(2500, "6789");
        }catch(AccountException e){
            System.out.println("Test 4: [PASS], Premature withdrawal blocked: " + e.getMessage());
        }
    }
}
