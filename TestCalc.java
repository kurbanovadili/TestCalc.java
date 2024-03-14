package TestCalc;
import java.util.Scanner;

class TestCalc {
    public static void main(String[] args) throws Exception {
        try {

            int firstNumber;
            int secondNumber;
            boolean isRoman = false;

            Scanner sc = new Scanner(System.in);
            System.out.println("Введите арифметическое выражение");
            String numbers = sc.nextLine();

            String[] num = numbers.split("[+*/-]");


            if (num.length < 2) throw new Exception("Строка не является математической операцией");

            if (num.length > 2) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            if ((isRoman(num[0]) && !isRoman(num[1])) || (!isRoman(num[0]) && isRoman(num[1]))) throw new Exception("Используются одновременно разные системы счисления");

            if (isRoman(num[0]) && isRoman(num[1])) {
                isRoman = true;
                firstNumber = convert(num[0]);
                secondNumber = convert(num[1]);
            } else {
                firstNumber = Integer.parseInt(num[0]);
                secondNumber = Integer.parseInt(num[1]);
            }

            String operation = operation(numbers);

            int result = calc(firstNumber, secondNumber, operation);
            if (isRoman) {
                if (result < 0) throw new Exception("В римской системе счислений нет отрицательных чисел");
                else System.out.println(roman[result]);
            } else {
                System.out.println(result);
            }
        }
        catch (NumberFormatException e) {  //перехват исключения
            System.out.println("Калькулятор работает только с целыми значениями");
        }


    }
    static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    static int calc(int firstNumber, int secondNumber, String operation) throws Exception {
        if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
            throw new Exception("Калькулятор работает только с числами от 1 до 10");
        }
        int result = 0;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            default:
                System.out.println("Невозможно выполнить арифметическое действие");
        }
        return result;
    }
    static String operation(String numbers) {
        String operation;
        if (numbers.contains("+")) {
            operation = "+";
            return operation;
        }
        if (numbers.contains("-")) {
            operation = "-";
            return operation;
        }
        if (numbers.contains("*")) {
            operation = "*";
            return operation;
        }
        if (numbers.contains("/")) {
            operation = "/";
            return operation;
        } else {
            return null;
        }
    }
    static boolean isRoman(String num) {
        boolean isRoman = false;
        for (String s : roman) {
            if (num.equals(s)) {
                isRoman = true;
                break;
            }
        }
        return isRoman;
    }
    static int convert (String num) {
        int value = 0;
        for (int i = 0; i< roman.length; i++) {
            if (num.equals(roman[i])){
                value = i;
                break;
            }
        }
        return value;
    }
}
