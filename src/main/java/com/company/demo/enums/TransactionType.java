package com.company.demo.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum TransactionType {
    VIEWINVOICE,
    PAYMENT;

    public static Optional<TransactionType> get(String transType){
        return Stream.of(values())
                .filter(v->v.name().equalsIgnoreCase(transType))
                .findFirst();
    }
}
