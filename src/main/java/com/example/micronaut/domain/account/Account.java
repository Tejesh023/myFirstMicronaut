package com.example.micronaut.domain.account;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class Account {

    private String accountId;

    private String customerId;

    private String identityType;

    private String activeSparksCard;

    private String cvv;
}