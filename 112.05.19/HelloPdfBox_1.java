import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class HelloPdfBox_1 {
  public static void main(String[] args) throws IOException {
    File myFile = new File("1-s2.0-S2214212622002514-main.pdf");
    try (PDDocument doc = PDDocument.load(myFile)){
      PDFTextStripper stripper = new PDFTextStripper();
      String text = stripper.getText(doc);
      int p = text.lastIndexOf("References") ;
      String refs = text.substring(p);
      System.out.println(refs);
    }
  }
}