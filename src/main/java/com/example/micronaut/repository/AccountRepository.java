package com.example.micronaut.repository;

import com.example.micronaut.domain.account.Account;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.List;

@Singleton
public class AccountRepository {

    private static final List<Account> accounts = Arrays.asList(
            new Account("1", "1234", "UK", "98761234", "123"),
            new Account("2", "1111", "UK", "98761111", "120"));

    public List<Account> findAllAccounts() {
        return accounts;
    }
}