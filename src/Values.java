public class Values {

    public static boolean checkNumberValue (int numberOne, int numberTwo) {
        if (((numberOne > 0) && (numberOne <= 10)) && ((numberTwo > 0) && (numberTwo <= 10))) {
            return true;
        } else {
            System.out.println("Numbers of the wrong range or mixed Arabic and Roman");
            System.exit(0);
            return false;
        }
    }
    public static int calc (int one, String operator, int two) {
        switch (operator) {
            case "+": return one + two;
            case "-": return one - two;
            case "*": return  one * two;
            case "/": return one / two;
            default: {
                System.out.println("You have entered an invalid mathematical operation");
                System.exit(0);
            }
        }
        return -1;
    }
}
