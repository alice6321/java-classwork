import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example2 {
    public static void main(String[] args) {
        final String regex = "(\\d{2,4})-(\\d{6,7})";
        final String string = "04-7232105\n"
   + "0922-100200\n"
   + "0988-486269\n"
   + "04-8696326\n"
   + "02-7965662\n"
   + "02-7266566\n";
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
