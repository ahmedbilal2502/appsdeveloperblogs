package com.appsdeveloperblogs.app.ws.examples;

import java.util.*;

public class CommonTesting {
    public static void main(String[] args) {
        List<String> successVas = new ArrayList<>();
        successVas.add("value1");
        successVas.add("value2");
        successVas.add("value3");

        String offerName = "existingOffer";

        if (successVas.size() > 0) {
            offerName = offerName + "+" + String.join(" + ", successVas);
        }

        System.out.println(offerName);
    }
}
