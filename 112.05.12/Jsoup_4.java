import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Jsoup_4{
  Jsoup_4() {
    try {
      Document doc = Jsoup.connect("https://wos-journal.info/?jsearch=IEEE+Access").get();
      String string = doc.toString();
      
      final String regex = "Impact Factor \\(IF\\):\n"
   + "    </div>\n"
   + "    <div class=\\\"content col-8 col-md-9\\\">\n"
   + "     ([\\d\\.]+)\n"
   + "    </div>";
      
      final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
      final Matcher matcher = pattern.matcher(string);
      
      while (matcher.find()) {
        System.out.println("Full match: " + matcher.group(0));
        
        for (int i = 1; i <= matcher.groupCount(); i++) {
          System.out.println("Group " + i + ": " + matcher.group(i));
        }
      }
    }catch(IOException e) {      
    } 
  }
  public static void main(String[] args) {
    new Jsoup_4();
  }
}
