import java.awt.*;
import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
 
public class PDFBox_1 {
 
  public static void main(String args[]) {
    PDDocument doc = new PDDocument();
    PDPage pdPage = new PDPage();
    doc.addPage(pdPage);
    try {
      PDPageContentStream content = new PDPageContentStream(doc, pdPage);
      
      content.beginText();
      content.newLineAtOffset(25, 700);
      content.setFont(PDType1Font.HELVETICA, 12);
      content.showText("Hello World");
      content.endText();
      
      PDFont chifont = PDType0Font.load(doc, new FileInputStream("C:\\Windows\\Fonts\\kaiu.ttf"), false);
      content.beginText();                                   
      content.newLineAtOffset(25, 600);
      content.setFont(chifont, 12);
      content.showText("中文測試");
      content.endText();
      
      PDImageXObject pdImage = PDImageXObject.createFromFile("kitty.jpg",doc);
      content.drawImage(pdImage, 70, 250);
      
      content.close();
      doc.save("test_2.pdf");
      doc.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    if (Desktop.isDesktopSupported()) {
      try {
        File myFile = new File("test_2.pdf");
        Desktop.getDesktop().open(myFile);
      } catch (IOException ex) {
      }
    }  
  }
}