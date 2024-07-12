package com.inventory.management.inventorymanager.exception;

public class InventoryException extends RuntimeException{

    private int statusCode;
    private String expMsg;
    private String expDetails;

    public InventoryException() {
        super();
    }

    public InventoryException(int statusCode, String expMsg, String expDetails) {
        super(expMsg);
        this.statusCode = statusCode;
        this.expMsg = expMsg;
        this.expDetails = expDetails;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getExpMsg() {
        return expMsg;
    }

    public String getExpDetails() {
        return expDetails;
    }
}
