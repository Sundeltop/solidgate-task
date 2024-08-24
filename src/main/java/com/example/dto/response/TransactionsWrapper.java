package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TransactionsWrapper {

    private final Map<String, TransactionJson> transactions = new HashMap<>();

    @JsonAnySetter
    private void setTransactions(String key, TransactionJson transaction) {
        transactions.put(key, transaction);
    }
}
