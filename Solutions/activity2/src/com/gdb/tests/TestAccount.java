package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 2: Test Account Suite ===");

        // NOTE: If you completed Activity 1 successfully, paste your working Account.java code into com.gdb.domain.

        Account acc = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE");

        // TODO: Step 1 - Test Initial Balance (Assert balance == 5000.0)
        boolean test1 = (acc.getBalance() == 5000.0);
        System.out.println("Test 1 (Initial Balance 5000.0): " + (test1 ? "[PASS]" : "[FAIL]"));

        // TODO: Step 2 - Test Valid Deposit (Deposit 2000.0 -> Assert balance == 7000.0)
        boolean depositStatus = acc.deposit(2000.0);
        boolean test2 = (depositStatus && acc.getBalance() == 7000.0);
        System.out.println("Test 2  (Deposit 2000.0 -> Assert balance == 7000.0): " + (test2 ?  "[PASS]" : "[FAIL]") );

        // TODO: Step 3 - Test Negative Deposit (Deposit -500.0 -> Assert returns false and balance stays 7000.0)
        depositStatus = acc.deposit(-500.0);
        boolean test3 = (!depositStatus && acc.getBalance() == 7000.0);
        System.out.println("Test 3 (Deposit -500.0 -> Assert returns false and balance stays 7000.0): " + (test3 ? "[PASS]" : "[FAIL]"));


        // TODO: Step 4 - Test Valid Withdrawal (Withdraw 3000.0 -> Assert balance == 4000.0)
        boolean withdrawalStatus = acc.withdraw(3000.0);
        boolean test4 = (withdrawalStatus && acc.getBalance() == 4000.0);
        System.out.println("Test 4 (Withdraw 3000.0 -> Assert balance == 4000.0): " + (test4 ? "[PASS]" : "[FAIL]"));

        // TODO: Step 5 - Test Exceeding Withdrawal (Withdraw 10000.0 -> Assert returns false and balance stays 4000.0)
        withdrawalStatus = acc.withdraw(10000.0);
        boolean test5 = (!withdrawalStatus && acc.getBalance() == 4000.0);
        System.out.println("Test 5 (Withdraw 10000.0 -> Assert returns false and balance stays 4000.0): " + (test5 ? "[PASS]" : "[FAIL]"));

        // TODO: Step 6 - Test Negative Withdrawal (Withdraw -100.0 -> Assert returns false and balance stays 4000.0)
        withdrawalStatus = acc.withdraw(-100.0);
        boolean test6 = (!withdrawalStatus && acc.getBalance() == 4000.0);
        System.out.println("Test 6 (Withdraw -100.0 -> Assert returns false and balance stays 4000.0): " + (test6 ? "[PASS]" : "[FAIL]"));

        System.out.println("=== Complete Activity 2 unit tests and verify output ===");
    }
}
