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
            throw new IncorrectTypeOfNumbersException("Write please numbers of one type (arabic or roman) between 1 and 10");
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
        romanArabicMap.put("XXI", 21);
        romanArabicMap.put("XXII", 22);
        romanArabicMap.put("XXIII", 23);
        romanArabicMap.put("XXIV", 24);
        romanArabicMap.put("XXV", 25);
        romanArabicMap.put("XXVI", 26);
        romanArabicMap.put("XXVII", 27);
        romanArabicMap.put("XXVIII", 28);
        romanArabicMap.put("XXIX", 29);
        romanArabicMap.put("XXX", 30);
        romanArabicMap.put("XXXI", 31);
        romanArabicMap.put("XXXII", 32);
        romanArabicMap.put("XXXIII", 33);
        romanArabicMap.put("XXXIV", 34);
        romanArabicMap.put("XXXV", 35);
        romanArabicMap.put("XXXVI", 36);
        romanArabicMap.put("XXXVII", 37);
        romanArabicMap.put("XXXVIII", 38);
        romanArabicMap.put("XXXIX", 39);
        romanArabicMap.put("XL", 40);
        romanArabicMap.put("XLI", 41);
        romanArabicMap.put("XLII", 42);
        romanArabicMap.put("XLIII", 43);
        romanArabicMap.put("XLIV", 44);
        romanArabicMap.put("XLV", 45);
        romanArabicMap.put("XLVI", 46);
        romanArabicMap.put("XLVII", 47);
        romanArabicMap.put("XLVIII", 48);
        romanArabicMap.put("XLIX", 49);
        romanArabicMap.put("L", 50);
        romanArabicMap.put("LI", 51);
        romanArabicMap.put("LII", 52);
        romanArabicMap.put("LIII", 53);
        romanArabicMap.put("LIV", 54);
        romanArabicMap.put("LV", 55);
        romanArabicMap.put("LVI", 56);
        romanArabicMap.put("LVII", 57);
        romanArabicMap.put("LVIII", 58);
        romanArabicMap.put("LIX", 59);
        romanArabicMap.put("LX", 60);
        romanArabicMap.put("LXI", 61);
        romanArabicMap.put("LXII", 62);
        romanArabicMap.put("LXIII", 63);
        romanArabicMap.put("LXIV", 64);
        romanArabicMap.put("LXV", 65);
        romanArabicMap.put("LXVI", 66);
        romanArabicMap.put("LXVII", 67);
        romanArabicMap.put("LXVIII", 68);
        romanArabicMap.put("LXIX", 69);
        romanArabicMap.put("LXX", 70);
        romanArabicMap.put("LXXI", 71);
        romanArabicMap.put("LXXII", 72);
        romanArabicMap.put("LXXIII", 73);
        romanArabicMap.put("LXXIV", 74);
        romanArabicMap.put("LXXV", 75);
        romanArabicMap.put("LXXVI", 76);
        romanArabicMap.put("LXXVII", 77);
        romanArabicMap.put("LXXVIII", 78);
        romanArabicMap.put("LXXIX", 79);
        romanArabicMap.put("LXXX", 80);
        romanArabicMap.put("LXXXI", 81);
        romanArabicMap.put("LXXXII", 82);
        romanArabicMap.put("LXXXIII", 83);
        romanArabicMap.put("LXXXIV", 84);
        romanArabicMap.put("LXXXV", 85);
        romanArabicMap.put("LXXXVI", 86);
        romanArabicMap.put("LXXXVII", 87);
        romanArabicMap.put("LXXXVIII", 88);
        romanArabicMap.put("LXXXIX", 89);
        romanArabicMap.put("XC", 90);
        romanArabicMap.put("XCI", 91);
        romanArabicMap.put("XCII", 92);
        romanArabicMap.put("XCIII", 93);
        romanArabicMap.put("XCIV", 94);
        romanArabicMap.put("XCV", 95);
        romanArabicMap.put("XCVI", 96);
        romanArabicMap.put("XCVII", 97);
        romanArabicMap.put("XCVIII", 98);
        romanArabicMap.put("XCIX", 99);
        romanArabicMap.put("C", 100);
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