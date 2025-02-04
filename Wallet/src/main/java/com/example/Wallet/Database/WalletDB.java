package com.example.Wallet.Database;

import com.example.Wallet.Entity.Wallet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletDB {

    private static WalletDB instance;
    private final Map<String, Wallet> db;

    private WalletDB() {
        db = new ConcurrentHashMap<>();
    }

    public static synchronized WalletDB getInstance() {
        if(instance == null) {
            instance = new WalletDB();
        }
        return instance;
    }

    public Map<String, Wallet> getDb() {
        return db;
    }


}
