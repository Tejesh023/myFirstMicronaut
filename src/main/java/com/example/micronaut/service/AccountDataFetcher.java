//package com.example.micronaut.service;
//
//import com.example.micronaut.domain.Account;
//import graphql.schema.DataFetcher;
//import graphql.schema.DataFetchingEnvironment;
//public class AccountDataFetcher implements DataFetcher<Account> {
//    @Override
//    public Account get(DataFetchingEnvironment dataFetchingEnvironment) {
//        return Account.builder()
//                .accountId("1234")
//                .customerId("123")
//                .identityType("UK")
//                .activeSparksCard("987654321")
//                .cvv("123")
//                .build();
//    }
//}
