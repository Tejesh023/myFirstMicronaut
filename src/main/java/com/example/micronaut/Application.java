package com.example.micronaut;

import io.micronaut.configuration.graphql.GraphQLRequestBody;
import io.micronaut.configuration.graphql.GraphQLResponseBody;
import io.micronaut.runtime.Micronaut;
import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.Max;

import java.util.List;

@Introspected(classes = {GraphQLRequestBody.class, GraphQLResponseBody.class})
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}