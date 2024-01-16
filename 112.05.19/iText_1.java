import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.font.*;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData; 
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image; 
import java.awt.*;
import java.io.*;

public class iText_1 {    
  public static void main(String args[]) throws Exception {
    String dest = "test_1.pdf";       
    PdfWriter writer = new PdfWriter(dest);           
    PdfDocument pdf = new PdfDocument(writer);              
    Document doc = new Document(pdf);              
    
    Paragraph paragraph1 = new Paragraph("Hello World"); 
    doc.add(paragraph1);  
    
    PdfFont chiFont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\kaiu.ttf",PdfEncodings.IDENTITY_H);
    doc.add(new Paragraph("中文測試").setFont(chiFont)); 
    
    String imFile = "kitty.png";       
    ImageData data = ImageDataFactory.create(imFile);              
    Image image = new Image(data);                        
    doc.add(image);              
    
    doc.close();                               
    if (Desktop.isDesktopSupported()) {
      try {
        File myFile = new File("test_1.pdf");
        Desktop.getDesktop().open(myFile);
      } catch (IOException ex) {
      }
    }  
  } 
}  