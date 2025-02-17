import java.util.Scanner;

public class StringProcessor {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString() {
        while (true) {
            System.out.print("Vvedit ryadok (min 2 slopv po 3+ simv): ");
            String userInput = scanner.nextLine().trim();
            
            String[] words = userInput.split("\\s+");
            
            if (words.length >= 2 && checkWordsLength(words)) {
                return userInput;
            }
            System.out.println("Error! Sprobuy she raz.");
        }
    }

    private static boolean checkWordsLength(String[] words) {
        for (String word : words) {
            if (word.length() < 3) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String text) {
        char[] charArray = text.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(charArray);
    }

    public static String reverseWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(reverseString(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String inputText = inputString();
        
        while (true) {
            System.out.println("""
            ===Hello user!===
            1.Vivesti ryadok v zvorytnomu poriadku
            2.Perevertaty kozne slovo
            3.Exit     

                    """);
           
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.println("Result: " + reverseString(inputText));
                    break;
                case "2":
                    System.out.println("Result: " + reverseWords(inputText));
                    break;
                case "3":
                    System.out.println("Exit...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Mimo na knopku nazhal");
            }
        }
    }
}