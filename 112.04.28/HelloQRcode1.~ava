import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.*; // HashMap, Map
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class HelloQRcode1 implements ActionListener {
  JFrame f;
  JTextField txt;
  JLabel lab;
  
  HelloQRcode1() {
    f = new JFrame("HelloQRcode1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    txt = new JTextField(20);
    txt.addActionListener(this);
    c.add(txt);
    lab = new JLabel();
    c.add(lab);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public static BufferedImage generateQRCodeImage(String barcodeText)
  throws Exception {
    Map<EncodeHintType, Object> hints = new HashMap<>();
    hints.put(EncodeHintType.CHARACTER_SET, CharacterSetECI.UTF8);
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
    hints.put(EncodeHintType.MARGIN, 0);
    BarcodeFormat format = BarcodeFormat.QR_CODE;
    BitMatrix matrix = null;
    try {
      matrix =
      new MultiFormatWriter().encode(barcodeText, format, 200, 200, hints);
    } catch (WriterException we) {
      we.printStackTrace();
    }
    MatrixToImageConfig config =
    new MatrixToImageConfig(Color.black.getRGB(), Color.white.getRGB());
    BufferedImage qrcode = MatrixToImageWriter.toBufferedImage(matrix, config);
    return qrcode;
  }
  
  public void actionPerformed(ActionEvent ae) {
    try {
      BufferedImage img = generateQRCodeImage(txt.getText());
      lab.setIcon(new ImageIcon(img));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args){
    new HelloQRcode1();
  }
}