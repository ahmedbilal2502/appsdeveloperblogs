package com.appsdeveloperblogs.app.ws;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class test {
    public static void main(String[] args) {

        Map<String, String> iweRequest = new HashMap<>();
        // body
        iweRequest.put("msisdn", "asdas");
//		iweRequest.put("TemplateId", cacheClient.getConfigurations(Constants.OTP_SMS_TEMPLATE_ID + smsCase));
        iweRequest.put("templateId", "3210");

        iweRequest.put("smsKeyValuePairs", "asd");
        iweRequest.put("loggingToken", "dsada");

        System.out.println(iweRequest.toString());





        String regex = "^((300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326|327|328|329|330|331|332|333|334|335|336|337|338|339|340|341|342|343|344|345|346|347|348|349|355|364|370)|0(300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326|327|328|329|330|331|332|333|334|335|336|337|338|339|340|341|342|343|344|345|346|347|348|349|355|364|370)|92(300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326|327|328|329|330|331|332|333|334|335|336|337|338|339|340|341|342|343|344|345|346|347|348|349|355|364|370))\\d{7}$";
        String msisdn = "3318184904"; // Example MSISDN

        // If number starts with "92", update it to start with "0"
        if (msisdn.startsWith("92")) {
            msisdn = "0" + msisdn.substring(2);
        }

        if (isUfoneMSISDN(msisdn, regex)) {
            if (msisdn.startsWith("92")) {
                msisdn = "0" + msisdn.substring(2);
            }
            if (!msisdn.startsWith("0")){
                msisdn = "0" + msisdn;
            }
            System.out.println(msisdn + " belongs to Ufone.");
        } else {
            System.out.println(msisdn + " does not belong to Ufone.");
        }
    }

    public static boolean isUfoneMSISDN(String msisdn, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(msisdn);
        return matcher.matches();
    }
}
