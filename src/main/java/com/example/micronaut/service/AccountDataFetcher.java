package com.example.micronaut.service;

import com.example.micronaut.domain.account.Account;
import com.example.micronaut.repository.AccountRepository;
import graphql.schema.DataFetcher;
import jakarta.inject.Singleton;

@Singleton
public class AccountDataFetcher {
    private final AccountRepository repository;

    public AccountDataFetcher(AccountRepository repository) {
        this.repository = repository;
    }

    public DataFetcher<Account> getAccountByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String accountId = dataFetchingEnvironment.getArgument("id");
            return repository.findAllAccounts()
                    .stream()
                    .filter(account -> account.getAccountId().equals(accountId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
