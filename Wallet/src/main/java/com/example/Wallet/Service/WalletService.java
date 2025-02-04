package com.example.Wallet.Service;

import com.example.Wallet.Database.WalletDB;
import com.example.Wallet.Entity.TransactionType;
import com.example.Wallet.Exceptions.NoTransactionsException;
import com.example.Wallet.Entity.Transaction;
import com.example.Wallet.Entity.User;
import com.example.Wallet.Entity.Wallet;
import com.example.Wallet.Exceptions.InsufficientBalanceException;
import org.hibernate.internal.log.SubSystemLogging;

import java.math.BigDecimal;
import java.util.List;

public class WalletService {
    public void createWallet(String name, String number) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if(number == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }

        User user = new User(name , number);
        Wallet wallet = new Wallet(user);
        WalletDB.getInstance().getDb().put(wallet.getAccountNumber(), wallet);

        System.out.println("Account created! Your account number is " + wallet.getAccountNumber());
    }

    public void topUp(String accountNumber, BigDecimal amount) {
        Wallet wallet = WalletDB.getInstance().getDb().get(accountNumber);
        wallet.setBalance(wallet.getBalance().add(amount));
    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, BigDecimal amount) {
        if(senderAccountNumber == null || receiverAccountNumber == null || amount == null) {
            throw new IllegalArgumentException("Invalid transfer details provided");
        }

        Wallet sender = WalletDB.getInstance().getDb().get(senderAccountNumber);
        Wallet receiver = WalletDB.getInstance().getDb().get(receiverAccountNumber);

        if(sender == null) {
            throw new IllegalArgumentException("Sender account not found");
        }
        if(receiver == null) {
            throw new IllegalArgumentException("Receiver account not found");
        }

        if(sender.getBalance().subtract(amount).compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new InsufficientBalanceException();
        }

        Transaction senderTransaction = new Transaction(
                senderAccountNumber,
                receiverAccountNumber,
                amount,
                TransactionType.DEBIT);
        sender.addTransaction(senderTransaction);
        sender.setBalance(sender.getBalance().subtract(amount));

        Transaction receiverTransaction = new Transaction(
                receiverAccountNumber,
                senderAccountNumber,
                amount,
                TransactionType.CREDIT);
        receiver.addTransaction(receiverTransaction);
        receiver.setBalance(receiver.getBalance().add(amount));


        System.out.println("Voila! Money tranfer complete!");
    }

    public void overview() {
        System.out.println("A shit here we go again!!");
        List<Wallet> allWallets = WalletDB.getInstance().getDb().values().stream().toList();
        allWallets.forEach(wallet -> System.out.println(wallet.toString()));
    }

    public void accountStatement(String accountNumber) {
        if(accountNumber == null) {
            throw new IllegalArgumentException("Invalid accountNumber to get account statment");
        }
        Wallet wallet= WalletDB.getInstance().getDb().get(accountNumber);
        List<Transaction> transactions = wallet.getTransactions();
        if(transactions.size() == 0) {
            System.out.println("Woops, looks like you have no transactions!");
            return;
        }
        System.out.println("Printing all transactions for user " + wallet.getUser().getName() + "");
        transactions.forEach(transaction -> System.out.println(transaction.toString()));
    }
}
