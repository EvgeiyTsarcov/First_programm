public class romanNumber {
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
                        {
                    System.out.println("Arabic numbers cannot be negative or the result is greater than 3999");
                    System.exit(0);
                        }
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
    public static String convertRoman(String romanNumberOne,String operatorRoman, String romanNumberTwo)
    {
        int converOne = convertArabianInRoman(romanNumberOne);
        int converTwo = convertArabianInRoman(romanNumberTwo);
        int rezultRoman = 0;
        if ((converOne != 0) && (converTwo != 0))
        {
            Main.checkNumberValue(converOne,converTwo);
            rezultRoman = Main.calc(converOne,operatorRoman,converTwo);
            String roman = romanNumber.of(rezultRoman);
            return roman;
        }
        return "Both or one of the numbers are not Roman";
    }
    public static int convertArabianInRoman(String arabianInRoman)
    {
        int x = 0;
        int y = 0;
        switch (arabianInRoman)
        {
            case "I":
            {
                return  1;
            }
            case "II":
            {
                return 2;
            }
            case "III":
            {
                return 3;
            }
            case "IV":
            {
                return 4;
            }
            case "V":
            {
                return 5;
            }
            case "VI":
            {
                return 6;
            }
            case "VII":
            {
                return 7;
            }
            case "VIII":
            {
                return 8;
            }
            case "IX":
            {
                return 9;
            }
            case "X":
            {
                return 10;
            }
            default:
                return 0;
        }
    }


}
