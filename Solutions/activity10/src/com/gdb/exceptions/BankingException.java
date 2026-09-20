package com.gdb.exceptions;

public class BankingException extends AccountException {
    public BankingException(String message) {
        super(message);
    }
}
