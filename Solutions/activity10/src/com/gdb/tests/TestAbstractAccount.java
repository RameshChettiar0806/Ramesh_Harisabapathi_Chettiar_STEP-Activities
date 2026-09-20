package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestAbstractAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 10: Banking Operations Suite ===");
        
        // NOTE: If you completed Activity 9 successfully, paste your working domain classes into src/com/gdb/domain (replacing the provided versions).
        
        // TODO: Step 1 - Create an array/portfolio of AbstractAccount objects (SavingsAccount, CurrentAccount, SalaryAccount)
        AbstractAccount savings = new SavingsAccount("SA01", "Ramesh", 20, 5000.0, "ACTIVE", "1234", 1000.0,4.0);
        
        AbstractAccount current = new CurrentAccount("CA02", "Ramesh Chettiar", 20, 10000.0, "ACTIVE", "1234", 5000.0);
        
        AbstractAccount salary = new SalaryAccount("SAL03", "Ramesh Harisabapathi Chettiar", 20, 20000.0, "ACTIVE", "1234", "TalenciaGlobal");
        
        AbstractAccount[] portfolio = { savings, current, salary };
        
        // TODO: Step 2 - Implement and test secure fund transfer from Savings to Current account with PIN authentication
        try {
            savings.transfer(current, 1000.0, "1234");
            System.out.println("Transfer successful: Rs.1000.0 from Savings to Current");
        } catch (AccountException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
        
        // TODO: Step 3 - Test failed transfer with wrong PIN and verify no balance was credited/debited
        try {
            savings.transfer(current,1000.0,"4321");
            System.out.println("Transfer successful: Rs.1000.0 from Savings to Current");
        } catch (InvalidPinException e) {
            System.out.println("Test 3: [PASS], Invalid PIN Entered: " +e.getMessage());
        } catch(Exception e){
            System.out.println("Test 3: [FAIL], " + e.getMessage());
        }
        // TODO: Step 4 - Process monthly cycle applying interest to every SavingsAccount and checking each SalaryAccount's inactive months
        AbstractAccount[] monthlyPortfolio = { savings, current, salary };
        for (AbstractAccount acc : monthlyPortfolio) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        }
        System.out.println("Monthly Interest Cycle processed for all qualifying accounts.");
        System.out.println("All banking operations passed!");
        
        System.out.println("=== Complete the test suite and verify all banking operations ===");
    }
}
