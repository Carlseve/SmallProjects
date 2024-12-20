import java.util.*;

import static java.lang.Character.toUpperCase;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        try {
            coolPrint(main.generateString("Hello World"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
                    Thread.sleep(50);
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
                    Thread.sleep(50);
                }
            }
        }
    }

    public static String falseAdder(String string, String letter) {
        String fakeString = string + letter;
        return fakeString;
    }
}