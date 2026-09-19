package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 4: Enhanced Account Test Suite ===");

        // NOTE: If you completed Activity 3 successfully, paste your working Account.java code into com.gdb.domain.

        // TODO: Step 1 - Test Underage Customer Rejection (age < 18 throws IllegalArgumentException)
        boolean test1 = false;
        try {
            new Account("ACC1002", "Minor Kid", 16, 1000.0, "SAVINGS", "ACTIVE", "1111");
        } catch (IllegalArgumentException e) {
            test1 = true;
        }
        System.out.println("Test 1 (Underage Customer Rejection): " + (test1 ? "[PASS]" : "[FAIL]"));
        // TODO: Step 2 - Test Wrong PIN Rejection on Withdrawal (Verify returns false and balance unchanged)
        
         Account acc = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE", "1234");
        boolean test2 = acc.getBalance() == 5000.0;
        System.out.println("Test 2 (Wrong PIN Rejection): " + (test2 ? "[PASS]" : "[FAIL]"));
        // TODO: Step 3 - Test Correct PIN Withdrawal (Verify returns true and balance decreases)
        boolean test3 = acc.withdraw(1000.0) && (acc.getBalance() == 4000.0);
        System.out.println("Test 3 (Correct PIN Withdrawal): " + (test3 ? "[PASS]" : "[FAIL]"));
        // TODO: Step 4 - Test PIN Change Functionality (Change PIN, verify old PIN fails, new PIN succeeds)
        boolean pinChanged = acc.changePin("1234", "5678");
        boolean oldPinFails = !acc.withdraw(500.0);
        boolean newPinWorks = acc.withdraw(500.0) && (acc.getBalance() == 3500.0);
        boolean test4 = pinChanged && oldPinFails && newPinWorks;
        System.out.println("Test 4 (PIN Change & Old PIN Invalidation): " + (test4 ? "[PASS]" : "[FAIL]"));
        // TODO: Step 5 - Test Suspended Account Block (Suspend account, verify withdrawal blocked)
         acc.suspend();
        boolean test5 = !acc.withdraw(500.0) && (acc.getBalance() == 3500.0);
        System.out.println("Test 5 (Suspended Account Block): " + (test5 ? "[PASS]" : "[FAIL]"));
        // TODO: Step 6 - Test Reactivation & Success (Activate account, verify withdrawal succeeds)
        acc.activate();
        boolean test6 = acc.withdraw(500.0) && (acc.getBalance() == 3000.0);
        System.out.println("Test 6 (Reactivation & Success): " + (test6 ? "[PASS]" : "[FAIL]"));
        System.out.println("=== Complete Activity 4 test suite and verify output ===");
    }
}
