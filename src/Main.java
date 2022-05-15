
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int FirstNumber = 0;
        int SecondNumber = 0;
        int rezult = 0;
        String CharCheck = "";
        String CharCheckNumberOne = "";
        String CharCheckNumberTwo = "";
        String CheckRoman = "";
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Введите строку в формате число А, необходимая операция, число B.\n" +
                            "Список доступных операций: + - * /\n"+
                            "Числа A и B  должны быть оба Арабские или Римские\n" +
                            "Числа A и B  должны быть оба в диапозоне от 1 до 10 \n" +
                            "Пример для арабских чисел: 3 + 5 \n" +
                            "Пример для римских чисел: I + II");
        String consoltext = UserInput.nextLine();
        String[] UserInputWord;
        UserInputWord = consoltext.split("\\s");
        int counterString = UserInputWord.length;
        if (counterString != 3)
        {
            System.out.println("Вы ввели больше или меньше чем нужно чисел, так же возможно напутали с пробелом");
            System.exit(0);
        }
        if(UserInputWord[0] == null || UserInputWord[0].equals("")) {
            System.out.println("Вы ввели пустую строку или начали ее с пробела");
            System.exit(0);
            } else
            {

                try
                {
                    FirstNumber= Integer.parseInt(UserInputWord[0]);
                }
                catch (NumberFormatException e)
                {

                }
                try
                {
                    SecondNumber= Integer.parseInt(UserInputWord[2]);
                }
                catch (NumberFormatException e)
                {

                }
                CharCheckNumberOne = UserInputWord[0];
                CharCheckNumberTwo = UserInputWord[2];
                CharCheck = UserInputWord[1];
            }
        CheckRoman=convertRoman(CharCheckNumberOne,CharCheck,CharCheckNumberTwo);
        switch (CheckRoman)
        {
            case "В римских цифрах минуса или 0 нет, сорри":
            {
                System.out.println(CheckRoman);
                System.exit(0);
            }
            case "Оба или Одно из чисел не римские":
            {
               break;
            }
            default:
            {

                System.out.println(" Результат: " + CheckRoman);
                System.exit(0);
            }
        }
        CheckNumberValue(FirstNumber,SecondNumber);
        rezult = calc(FirstNumber,CharCheck,SecondNumber);
        System.out.println("Результат: " + rezult);

        UserInput.close();
    }
    public static boolean CheckNumberValue (int NumberOne, int NumberTwo)
    {
        if ( ((NumberOne > 0) && ( NumberOne <= 10 )) && ((NumberTwo > 0) && ( NumberTwo <= 10 )) )
        {
            return true;
        } else
        {
            System.out.println("Числа не нужного диапозона или смешанные арабские и римские");
            System.exit(0);
            return false;
        }
    }
    public static String convertRoman(String romanNumberOne,String operatorRoman, String romanNumberTwo)
    {
        int x = 0;
        int y = 0;
        int rezultRoman = 0;
        switch (romanNumberOne)
        {
            case "I":
            {
                x = 1;
                break;
            }
            case "II":
            {
                x = 2;
                break;
            }
            case "III":
            {
                x = 3;
                break;
            }
            case "IV":
            {
                x = 4;
                break;
            }
            case "V":
            {
                x = 5;
                break;
            }
            case "VI":
            {
                x = 6;
                break;
            }
            case "VII":
            {
                x = 7;
                break;
            }
            case "VIII":
            {
                x = 8;
                break;
            }
            case "IX":
            {
                x = 9;
                break;
            }
            case "X":
            {
                x = 10;
                break;
            }
        }
        switch (romanNumberTwo)
        {
            case "I":
            {
                y = 1;
                break;
            }
            case "II":
            {
                y = 2;
                break;
            }
            case "III":
            {
                y = 3;
                break;
            }
            case "IV":
            {
                y = 4;
                break;
            }
            case "V":
            {
                y = 5;
                break;
            }
            case "VI":
            {
                y = 6;
                break;
            }
            case "VII":
            {
                y = 7;
                break;
            }
            case "VIII":
            {
                y = 8;
                break;
            }
            case "IX":
            {
                y = 9;
                break;
            }
            case "X":
            {
                y = 10;
                break;
            }
        }
        if ((x != 0) && (y != 0))
        {
            CheckNumberValue(x,y);
            rezultRoman = calc(x,operatorRoman,y);
            String roman = RomanNumber.of(rezultRoman);
            return roman;
        }
        return "Оба или Одно из чисел не римские";
    }
    public static int calc (int one, String operator, int two)
    {
        switch (operator)
        {
            case "+": return one + two;
            case "-": return one - two;
            case "*": return  one * two;
            case "/": return one / two;
            default:
            {
                System.out.println("Вы ввели недопустимую математическую операцию");
                System.exit(0);
            }
        }
        return -1;
    }
}
class RomanNumber {
    public enum Digit {
        M(1000, 3),
        CM(900, 1),
        D(500, 1),
        CD(400, 1),
        C(100, 3),
        XC(90, 1),
        L(50, 1),
        XL(40, 1),
        X(10, 3),
        IX(9, 1),
        V(5, 1),
        IV(4, 1),
        I(1, 3);

        public final int value;
        public final String symbol = name();
        public final int maxArity;

        private Digit(int value, int maxArity) {
            this.value = value;
            this.maxArity = maxArity;
        }
    }

    private static final Digit[] DIGITS = Digit.values();

    public static String of(int number) {
        if (number < 1 || 3999 < number) {
            throw new IllegalArgumentException(String.format(
                    "Римские цифры имеют диапозон от 1 до 4000",
                    number
            ));
        }

        StringBuilder sb = new StringBuilder();
        for (Digit digit : DIGITS) {
            int value = digit.value;
            String symbol = digit.symbol;

            while (number >= value) {
                sb.append(symbol);
                number -= value;
            }
        }

        return sb.toString();
    }

    public static int parse(String roman) {
        if (roman.isEmpty()) {
            throw new NumberFormatException("Пустая строка тут нету символов");
        }

        int number = 0;
        int offset = 0;
        for (Digit digit : DIGITS) {
            int value = digit.value;
            int maxArity = digit.maxArity;
            String symbol = digit.symbol;

            for (int i = 0; i < maxArity && roman.startsWith(symbol, offset); i++) {
                number += value;
                offset += symbol.length();
            }
        }
        if (offset != roman.length()) {
            throw new NumberFormatException(String.format(
                    "Строка '%s' не содержит римских символов",
                    roman
            ));
        }
        return number;
    }

}




