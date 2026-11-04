package fr.simplon.domedespuys.enumeration;

public enum EnumPurchaseStatus {
    PENDING("pending"),
    PAID("value"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("cancelled");

    EnumPurchaseStatus(String value){}
}
