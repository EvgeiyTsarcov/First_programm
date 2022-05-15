
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
        System.out.println("Enter a string in the format number A, , required operation, number B.\n" +
                            "List of available operations: + - * /\n"+
                            "Digits A and B must be Arabic or Roman \n" +
                            "Digits A and B must be in the range from 1 to 10  \n" +
                            "Example for Arabic numerals: 3 + 5\n" +
                            "Example for Roman numerals: I + II");
        String consoltext = UserInput.nextLine();
        String[] UserInputWord;
        UserInputWord = consoltext.split("\\s");
        int counterString = UserInputWord.length;
        if (counterString != 3)
        {
            System.out.println("You have entered more or less numbers than you need, you may also have messed up with a space");
            System.exit(0);
        }
        if(UserInputWord[0] == null || UserInputWord[0].equals("")) {
            System.out.println("You entered an empty string or started it with a space");
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
            case "There is no minus or 0 in Roman numerals, sorry":
            {
                System.out.println(CheckRoman);
                System.exit(0);
            }
            case "Both or one of the numbers are not Roman":
            {
               break;
            }
            default:
            {

                System.out.println(" Result: " + CheckRoman);
                System.exit(0);
            }
        }
        CheckNumberValue(FirstNumber,SecondNumber);
        rezult = calc(FirstNumber,CharCheck,SecondNumber);
        System.out.println("Result: " + rezult);

        UserInput.close();
    }
    public static boolean CheckNumberValue (int NumberOne, int NumberTwo)
    {
        if ( ((NumberOne > 0) && ( NumberOne <= 10 )) && ((NumberTwo > 0) && ( NumberTwo <= 10 )) )
        {
            return true;
        } else
        {
            System.out.println("Numbers of the wrong range or mixed Arabic and Roman");
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
        return "Both or one of the numbers are not Roman";
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
                System.out.println("You have entered an invalid mathematical operation");
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
                    "Roman numerals have a range from 1 to 4000",
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
            throw new NumberFormatException("An empty string there are no characters here");
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
                    "The string '%s' does not contain Roman ",
                    roman
            ));
        }
        return number;
    }

}




