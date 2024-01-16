import java.io.*;
import java.util.regex.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class Jsoup_1{
  Jsoup_1() {
    try {
      Document doc = Jsoup.connect("https://www.mdpi.com/journal/cryptography").get();
      Elements links = doc.select("a[class=title-link][href~=(/2410-387X/7)]");
      for (Element link : links) {
        System.out.println(link.text());
      } 
    } catch(IOException e) {      
    } 
  }
  public static void main(String[] args) throws IOException {
    new Jsoup_1();
  }
}