package com.example.Wallet.Exceptions;

public class NoTransactionsException extends RuntimeException {
    public NoTransactionsException() {
        super("No transactions found for current user! Start paying with FK Money now!");
    }
}
