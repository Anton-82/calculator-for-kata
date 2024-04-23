import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = null;
        Scanner consol = new Scanner(System.in);

        System.out.println("Write mathematical task with two arabic or roman numbers:");
        input = consol.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String calc(String input) throws IncorrectArithmeticSignException, IncorrectNumberException, IncorrectTypeOfNumbersException, IncorrectValueOfResultException {
        int firstNumber = 0;
        int secondNumber = 0;
        String firstNumberString = null;
        String secondNumberString = null;
        String arithmeticSign = "";
        String[] listPartsOfString = new String[3];
        boolean isRomanNumbers = false;
        HashMap<String, Integer> romanArabicMap = createRomanArabicHashMap();
        HashMap<String, Integer> romanArabicMapForResult = createRomanArabicHashMapForResult();
        int result = 0;

        if (input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/") && input.split("\\+").length < 3) {
            listPartsOfString = input.split("\\+");
            arithmeticSign = "+";
        } else if (input.contains("-") && !input.contains("+") && !input.contains("*") && !input.contains("/") && input.split("-").length < 3) {
            listPartsOfString = input.split("-");
            arithmeticSign = "-";
        } else if (input.contains("*") && !input.contains("-") && !input.contains("+") && !input.contains("/") && input.split("\\*").length < 3) {
            listPartsOfString = input.split("\\*");
            arithmeticSign = "*";
        } else if (input.contains("/") && !input.contains("-") && !input.contains("*") && !input.contains("+") && input.split("/").length < 3) {
            listPartsOfString = input.split("/");
            arithmeticSign = "/";
        } else {
            throw new IncorrectArithmeticSignException("Write please one correct arithmetic sign '+' or '-' or '*' or '/'");
        }

        firstNumberString = listPartsOfString[0].trim();
        secondNumberString = listPartsOfString[1].trim();

        if (romanArabicMap.containsKey(firstNumberString) && romanArabicMap.containsKey(secondNumberString)) {
            isRomanNumbers = true;
            firstNumber = romanArabicMap.get(firstNumberString.trim());
            secondNumber = romanArabicMap.get(secondNumberString.trim());
        } else if (romanArabicMap.containsKey(firstNumberString) && !romanArabicMap.containsKey(secondNumberString)) {
            throw new IncorrectTypeOfNumbersException("Write please numbers of one type (arabic or roman)");
        } else if (!romanArabicMap.containsKey(firstNumberString) && romanArabicMap.containsKey(secondNumberString)) {
            throw new IncorrectTypeOfNumbersException("Write please numbers of one type (arabic or roman)");
        } else {
            try {
                firstNumber = Integer.parseInt(listPartsOfString[0].trim());
                secondNumber = Integer.parseInt(listPartsOfString[1].trim());
            } catch (NumberFormatException e) {
                throw new IncorrectNumberException("Write please correct arabic or roman numbers between 1 and 10");
            }
        }

        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1)
            throw new IncorrectNumberException("Write please correct numbers between 1 and 10");

        result = solver(firstNumber, arithmeticSign, secondNumber);

        if (isRomanNumbers) {
            for (Map.Entry<String, Integer> entry : romanArabicMapForResult.entrySet()) {
                if (entry.getValue().equals(result))
                    return "Result = " + entry.getKey();
            }
            throw new IncorrectValueOfResultException("We don't have roman sign for this result");
        }
        return "Result = " + String.valueOf(result);
    }

    static HashMap<String, Integer> createRomanArabicHashMap() {
        HashMap<String, Integer> romanArabicMap = new HashMap<>();
        romanArabicMap.put("I", 1);
        romanArabicMap.put("II", 2);
        romanArabicMap.put("III", 3);
        romanArabicMap.put("IV", 4);
        romanArabicMap.put("V", 5);
        romanArabicMap.put("VI", 6);
        romanArabicMap.put("VII", 7);
        romanArabicMap.put("VIII", 8);
        romanArabicMap.put("IX", 9);
        romanArabicMap.put("X", 10);
        return romanArabicMap;
    }

    static HashMap<String, Integer> createRomanArabicHashMapForResult() {
        HashMap<String, Integer> romanArabicMap = new HashMap<>();
        romanArabicMap.put("I", 1);
        romanArabicMap.put("II", 2);
        romanArabicMap.put("III", 3);
        romanArabicMap.put("IV", 4);
        romanArabicMap.put("V", 5);
        romanArabicMap.put("VI", 6);
        romanArabicMap.put("VII", 7);
        romanArabicMap.put("VIII", 8);
        romanArabicMap.put("IX", 9);
        romanArabicMap.put("X", 10);
        romanArabicMap.put("XI", 11);
        romanArabicMap.put("XII", 12);
        romanArabicMap.put("XIII", 13);
        romanArabicMap.put("XIV", 14);
        romanArabicMap.put("XV", 15);
        romanArabicMap.put("XVI", 16);
        romanArabicMap.put("XVII", 17);
        romanArabicMap.put("XVIII", 18);
        romanArabicMap.put("XIX", 19);
        romanArabicMap.put("XX", 20);
        return romanArabicMap;
    }

    static int solver(int firstNumber, String arithmeticSign, int secondNumber) {
        int result = 0;

        switch (arithmeticSign) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }

        return result;
    }

    static class IncorrectValueOfResultException extends Exception {
        IncorrectValueOfResultException(String errorMessage) {
            super((errorMessage));
        }
    }

    static class IncorrectTypeOfNumbersException extends Exception {
        IncorrectTypeOfNumbersException(String errorMessage) {
            super((errorMessage));
        }
    }

    static class IncorrectArithmeticSignException extends Exception {
        IncorrectArithmeticSignException(String errorMessage) {
            super((errorMessage));
        }
    }

    static class IncorrectNumberException extends Exception {
        IncorrectNumberException(String errorMessage) {
            super((errorMessage));
        }
    }
}