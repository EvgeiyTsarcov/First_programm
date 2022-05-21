
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = 0;
        int rezult = 0;
        String charCheck = "";
        String charCheckNumberOne = "";
        String charCheckNumberTwo = "";
        String checkRoman = "";
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a string in the format number A, , required operation, number B.\n" +
                            "List of available operations: + - * /\n"+
                            "Digits A and B must be Arabic or Roman \n" +
                            "Digits A and B must be in the range from 1 to 10  \n" +
                            "Example for Arabic numerals: 3 + 5\n" +
                            "Example for Roman numerals: I + II");
        String consolText = userInput.nextLine();
        String[] userInputWord;
        userInputWord = consolText.split("\\s");
        int counterString = userInputWord.length;
        if (counterString != 3) {
            System.out.println("You have entered more or less numbers than you need, you may also have messed up with a space");
            System.exit(0);
        }
        if(userInputWord[0] == null || userInputWord[0].equals("")) {
            System.out.println("You entered an empty string or started it with a space");
            System.exit(0);
            } else {
                try {
                    firstNumber= Integer.parseInt(userInputWord[0]);
                }
                catch (NumberFormatException e) {

                }
                try {
                    secondNumber= Integer.parseInt(userInputWord[2]);
                }
                catch (NumberFormatException e) {

                }
                charCheckNumberOne = userInputWord[0];
                charCheckNumberTwo = userInputWord[2];
                charCheck = userInputWord[1];
            }
        checkRoman=RomanNumber.convertRoman(charCheckNumberOne,charCheck,charCheckNumberTwo);


        switch (checkRoman) {
            case "There is no minus or 0 in Roman numerals, sorry": {
                System.out.println(checkRoman);
                System.exit(0);
            }
            case "Both or one of the numbers are not Roman": {
               break;
            }
            default: {

                System.out.println(" Result: " + checkRoman);
                System.exit(0);
            }
        }
        Values.checkNumberValue(firstNumber,secondNumber);
        rezult = Values.calc(firstNumber,charCheck,secondNumber);
        System.out.println("Result: " + rezult);
        userInput.close();
    }

    }






