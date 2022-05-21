public class RomanNumber {

        private static final Digit[] DIGITS = Digit.values();

        public static String ofAbabicToRoman(int number) {
            if (number < 1 || 3999 < number) {
                    System.out.println("Arabic numbers cannot be negative or the result is greater than 3999");
                    System.exit(0);
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



    public static String convertRoman(String romanNumberOne,String operatorRoman, String romanNumberTwo)
    {
        int converOne = convertArabianInRoman(romanNumberOne);
        int converTwo = convertArabianInRoman(romanNumberTwo);
        int rezultRoman = 0;
        if ((converOne != 0) && (converTwo != 0)) {
            Values.checkNumberValue(converOne,converTwo);
            rezultRoman = Values.calc(converOne,operatorRoman,converTwo);
            String roman = RomanNumber.ofAbabicToRoman(rezultRoman);
            return roman;
        }
        return "Both or one of the numbers are not Roman";
    }
    public static int convertArabianInRoman(String arabianInRoman) {
        int x = 0;
        int y = 0;
        switch (arabianInRoman) {
            case "I": {
                return  1;
            }
            case "II": {
                return 2;
            }
            case "III": {
                return 3;
            }
            case "IV": {
                return 4;
            }
            case "V": {
                return 5;
            }
            case "VI": {
                return 6;
            }
            case "VII": {
                return 7;
            }
            case "VIII": {
                return 8;
            }
            case "IX": {
                return 9;
            }
            case "X": {
                return 10;
            }
            default:
                return 0;
        }
    }


}
