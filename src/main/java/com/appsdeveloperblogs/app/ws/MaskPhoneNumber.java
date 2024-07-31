package com.appsdeveloperblogs.app.ws;

public class MaskPhoneNumber {
    public static String maskNumber(String phoneNumber) {
        return phoneNumber.replaceAll("(?<=\\d{3})\\d(?=\\d{3})", "x");
    }

    public static void main(String[] args) {
        String phoneNumber1 = "03335356369";
        String maskedNumber1 = maskNumber(phoneNumber1);
        System.out.println(maskedNumber1); // Output: 0333xxxxx6369

        String phoneNumber2 = "03125763147";
        String maskedNumber2 = maskNumber(phoneNumber2);
        System.out.println(maskedNumber2); // Output: 0123xxx6789
    }
}
