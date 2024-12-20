import java.util.*;


public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vad vill du få skrivet på ett coolt sätt? (stop för att avsluta)");
            String command = scanner.nextLine();
            Main main = new Main();
            try {
                coolPrint(main.generateString(command));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(command.equals("stop")) {
                isRunning = false;
            }
        }
    }

    public List<Character> generateString(String string) {
        List<Character> charList = new ArrayList<>();

        for (char c : string.toCharArray()) {
            charList.add(c);
        }
        return charList;
    }

    public static void coolPrint(List<Character> characterList) throws InterruptedException {
        Set<Character> upperAlphabetSet = new HashSet<>();
        Set<Character> lowerAlphabetSet = new HashSet<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            upperAlphabetSet.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            lowerAlphabetSet.add(c);
        }
        lowerAlphabetSet.add(' ');
        upperAlphabetSet.add(' ');

        String printOut = "";


        //Checks each character in the list created by the other method and calls falseAdder if
        //it's not the right one otherwise it adds it to the printout and prints it
        for (Character currentChar : characterList) {
            if (Character.isUpperCase(currentChar)) {
                for (Character upperChar : upperAlphabetSet) {
                    if (upperChar.equals(currentChar)) {
                        printOut += upperChar;
                        System.out.println(printOut);
                        break;
                    } else {
                        System.out.println(falseAdder(printOut, upperChar.toString()));
                    }
                    Thread.sleep(70);
                }
            } else if (Character.isLowerCase(currentChar) || currentChar == ' ') {
                for (Character lowerChar : lowerAlphabetSet) {
                    if (lowerChar.equals(currentChar)) {
                        printOut += lowerChar;
                        System.out.println(printOut);
                        break;
                    } else {
                        System.out.println(falseAdder(printOut, lowerChar.toString()));
                    }
                    Thread.sleep(70);
                }
            }
        }
    }

    //Creates a fake string to print a letter if it is the wrong one
    public static String falseAdder(String string, String letter) {
        String fakeString = string + letter;
        return fakeString;
    }
}