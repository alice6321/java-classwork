import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Jsoup_2{
  Jsoup_2() {
    try {
      Document doc = Jsoup.connect("https://images.webofknowledge.com/images/help/WOS/T_abrvjt.html").get();
      String string = doc.toString();
      final String regex = "<dt>([\\w\\s]+)<b></b></dt><dd><b>  TELECOMMUN SYST";
      
      
      final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
      final Matcher matcher = pattern.matcher(string);
      
      while (matcher.find()) {
        System.out.println("Full match: " + matcher.group(0));
        
        for (int i = 1; i <= matcher.groupCount(); i++) {
          System.out.println("Group " + i + ": " + matcher.group(i));
        }
        
      }catch(IOException e) {      
      } 
    }
  public static void main(String[] args) {
    new Jsoup_2();
  }
}