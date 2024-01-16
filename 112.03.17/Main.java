import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String answer = "";
        while (answer.length() != 4) {
            int digit = random.nextInt(10);
            String digitStr = Integer.toString(digit);
            if (!answer.contains(digitStr)) {
                answer += digitStr;
            }
        }
        int numGuesses = 0;
        while (true) {
            numGuesses++;
            System.out.print("Enter your guess (4 digits): ");
            String guess = scanner.nextLine();
            int numCorrect = 0;
            int numPartial = 0;
            for (int i = 0; i < 4; i++) {
                char c = guess.charAt(i);
                if (c == answer.charAt(i)) {
                    numCorrect++;
                } else if (answer.contains(Character.toString(c))) {
                    numPartial++;
                }
            }
            System.out.printf("%dA%dB\n", numCorrect, numPartial);
            if (numCorrect == 4) {
                System.out.printf("You won in %d guesses!\n", numGuesses);
                break;
            }
        }
        scanner.close();
    }
}
