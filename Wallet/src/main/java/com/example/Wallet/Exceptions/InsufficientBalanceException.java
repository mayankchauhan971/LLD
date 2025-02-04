package com.example.Wallet.Exceptions;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super("There isn't enough balance to proceed with your transaction, please top up!");


    }
}
