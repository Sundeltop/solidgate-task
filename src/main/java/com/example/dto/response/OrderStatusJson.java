package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter(PRIVATE)
@NoArgsConstructor
public class OrderStatusJson {

    @JsonProperty("transactions")
    private TransactionsWrapper transactions;

    public List<TransactionJson> getTransactions() {
        return transactions
                .getTransactions()
                .values()
                .stream()
                .toList();
    }
}
