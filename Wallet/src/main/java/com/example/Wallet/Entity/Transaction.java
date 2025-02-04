package com.example.Wallet.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    String from;
    String to;
    BigDecimal amount;
    LocalDateTime time;
    TransactionType type;

    public Transaction(String from, String to, BigDecimal amount, TransactionType type) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.type = type;
        this.time = LocalDateTime.now();

    }

    @Override
    public String toString() {
        return "Transaction done from " + from + " to " + to + " for amount " + amount + " on " + time.toString();
    }
}