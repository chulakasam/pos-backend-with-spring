package com.example.pos_backend.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }
    public static String generateItemId(){
        return "ITEM-"+ UUID.randomUUID();
    }

    public static String generateOrderDetailId() {
        return "Order-"+ UUID.randomUUID();
    }
}
