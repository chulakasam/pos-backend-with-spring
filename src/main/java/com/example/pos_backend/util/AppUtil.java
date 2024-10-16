package com.example.pos_backend.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }
    public static String generateItemId(){
        return "ITEM-"+ UUID.randomUUID();
    }

    public static String generateOrderId() {
        return "Order-"+ UUID.randomUUID();
    }

    public static String generateOrderDetailsId() {
        return "Order-Details"+ UUID.randomUUID();
    }
}
