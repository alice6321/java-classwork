import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class HelloQRcode2 implements ActionListener {
  JFrame f;
  JLabel lab;
  
  HelloQRcode2() {
    f = new JFrame("HelloQRcode2");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    lab = new JLabel();
    c.add(lab);
    
    JMenu m1 = new JMenu("File");
    JMenuItem m1_1 = new JMenuItem("Read image");
    m1_1.addActionListener(this);
    m1.add(m1_1);
    JMenuItem m1_2 = new JMenuItem("Exit");
    m1_2.addActionListener(this);
    m1.add(m1_2);
    JMenuBar mb = new JMenuBar();
    mb.add(m1);
    f.setJMenuBar(mb);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
    JFileChooser fc = new JFileChooser();
    fc.setDialogTitle("Please choose an image...");
    BufferedImage img = null;
    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fc.getSelectedFile();
      try {
        img = ImageIO.read(selectedFile);
        if (img != null) {
          lab.setIcon(new ImageIcon(img));
          LuminanceSource source =
            new BufferedImageLuminanceSource(img);
          BinaryBitmap bitmap =
            new BinaryBitmap(new HybridBinarizer(source));
          Hashtable<DecodeHintType, String> hints =
            new Hashtable<DecodeHintType, String>();
          hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
          Result result =
            new MultiFormatReader().decode(bitmap, hints);
          JOptionPane.showMessageDialog(f, result.getText());
        } else {
          throw
          new IllegalArgumentException ("Could not decode image.");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args){
    new HelloQRcode2();
  }
}
