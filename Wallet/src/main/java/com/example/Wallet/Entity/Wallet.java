package com.example.Wallet.Entity;

import com.example.Wallet.Database.WalletDB;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Getter
@Setter
public class Wallet {

    private static final AtomicLong counter = new AtomicLong(1000000L);

    BigDecimal balance;
    String accountNumber; // auto-generated
    List<Transaction> transactions;
    User user;

    public Wallet(User user) {
        this.transactions = new LinkedList<>();
        this.balance = BigDecimal.ZERO;
        this.accountNumber = generateAccountNumberSequentially();
        this.user = user;
    }

    @Override
    public String toString() {
        return "Transactions made by User " + user.getName() + " are: \n" +
                transactions.stream()
                        .map(transaction -> transaction.toString() + " \n")
                        .collect(Collectors.joining());
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    private String generateAccountNumber() {
        String uuid = UUID.randomUUID().toString();
        while(WalletDB.getInstance().getDb().get(uuid) != null) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    private String generateAccountNumberSequentially() {
        return Long.toString(counter.incrementAndGet());
    }
}
