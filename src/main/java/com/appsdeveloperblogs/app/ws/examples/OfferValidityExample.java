package com.appsdeveloperblogs.app.ws.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OfferValidityExample {

    public static void main(String[] args) {
        VAS vas = new VAS();
        Attributes attributes = new Attributes();
        attributes.setValue(30);

        // Assuming attributes.getValue() returns an integer number of days
        int validityDays = attributes.getValue();

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the new validity date
        LocalDate validityDate = currentDate.plusDays(validityDays);

        // Set the offer validity
        vas.setOfferValidity(String.valueOf(validityDate));

        // Output the validity date for confirmation
        System.out.println("Offer Validity Date: " + validityDate);
    }
}

class VAS {
    private String offerValidity;

    public void setOfferValidity(String offerValidity) {
        this.offerValidity = offerValidity;
    }

    public String getOfferValidity() {
        return offerValidity;
    }
}

class Attributes {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
