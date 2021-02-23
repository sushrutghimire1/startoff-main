package com.vit.startupapp.helperutils;

import java.util.UUID;

public class HelperUtils {

    public static String generateRandomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase().substring(0,10);
    }

}
