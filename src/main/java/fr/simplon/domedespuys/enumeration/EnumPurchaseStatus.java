package fr.simplon.domedespuys.enumeration;

import lombok.Getter;

@Getter
public enum EnumPurchaseStatus {
    PENDING("pending"),
    PAID("value"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("cancelled");

    private final String value;

    EnumPurchaseStatus(String value) {
        this.value = value;
    }
}
