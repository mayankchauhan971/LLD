package com.example.Wallet.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.UUID;

@Getter
public class User {
    UUID id;
    String name;
    String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = UUID.randomUUID();
    }
}
