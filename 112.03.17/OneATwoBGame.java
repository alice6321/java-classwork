import javax.swing.JOptionPane;
import java.util.Random;

public class OneATwoBGame {

    public static void main(String[] args) {
        Random random = new Random();
        int answer = random.nextInt(9000) + 1000; // 產生 1000 到 9999 的隨機數字
        int guess;
        int count = 0;
        do {
            guess = Integer.parseInt(JOptionPane.showInputDialog("請猜一個四位數字："));
            count++;
            String message = checkAnswer(guess, answer);
            JOptionPane.showMessageDialog(null, message);
        } while (guess != answer);
        JOptionPane.showMessageDialog(null, "恭喜你猜對了！總共猜了 " + count + " 次。");
    }

    // 檢查猜測結果，並回傳回饋訊息
    private static String checkAnswer(int guess, int answer) {
        int a = 0, b = 0;
        String guessStr = Integer.toString(guess);
        String answerStr = Integer.toString(answer);
        for (int i = 0; i < 4; i++) {
            if (guessStr.charAt(i) == answerStr.charAt(i)) {
                a++;
            } else if (answerStr.contains(guessStr.substring(i, i+1))) {
                b++;
            }
        }
        return a + "A" + b + "B";
    }
}
