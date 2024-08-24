package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsWrapper {

    private final Map<String, TransactionJson> transactions = new HashMap<>();

    @JsonAnySetter
    private void setTransactions(String key, TransactionJson transaction) {
        this.transactions.put(key, transaction);
    }

    public List<TransactionJson> getTransactions() {
        return transactions.values().stream().toList();
    }
}
