package com.appsdeveloperblogs.app.ws.examples;

public class abc {
    private static String convertToGB(String totalClaimReward) {
        double rewardInMB = Double.parseDouble(totalClaimReward);
        double rewardInGB = rewardInMB / 1024;
        return String.format("%.1f GBs", rewardInGB);
    }
    public static String toPascalCaseWithSpaces(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder pascalCaseName = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Capitalize the first letter of each word
            String capitalizedWord = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            pascalCaseName.append(capitalizedWord);

            // Add a space after each word, except for the last word
            if (i < words.length - 1) {
                pascalCaseName.append(" ");
            }
        }

        return pascalCaseName.toString();
    }



    public static void main(String[] args) {
        System.out.println(toPascalCaseWithSpaces("AHMED  BILAL"));
        System.out.println(convertToGB("1200"));
        /*String equation1 = "4-2=x";
        int result1 = solveEquation(equation1);
        System.out.println("Result: " + result1);*/

       // String equation2 = "1x0*12=1200";
      //  int result2 = solveEquation(equation2);
       // System.out.println("Result: " + result2);
    }

    public static int solveEquation(String equation) {
        // Split the equation into parts
        String[] parts = equation.split("[=]");
        String expression = parts[0];
        int result = Integer.parseInt(parts[1]);

        // Determine the operator
        char operator;
        int operatorIndex = -1;
        if (expression.contains("+")) {
            operator = '+';
            operatorIndex = expression.indexOf('+');
        } else if (expression.contains("-")) {
            operator = '-';
            operatorIndex = expression.indexOf('-');
        } else if (expression.contains("*")) {
            operator = '*';
            operatorIndex = expression.indexOf('*');
        } else if (expression.contains("/")) {
            operator = '/';
            operatorIndex = expression.indexOf('/');
        } else {
            throw new IllegalArgumentException("Unsupported operator");
        }

        // Extract operands
        int operand1 = Integer.parseInt(expression.substring(0, operatorIndex).trim());
        int operand2 = Integer.parseInt(expression.substring(operatorIndex + 1).trim());

        // Solve for the missing operand
        int x;
        switch (operator) {
            case '+':
                x = result - operand2;
                break;
            case '-':
                x = operand1 - result;
                break;
            case '*':
                x = result / operand2;
                break;
            case '/':
                x = operand1 / result;
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator");
        }

        return x;
    }
}

