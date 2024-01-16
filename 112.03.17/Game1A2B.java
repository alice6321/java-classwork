import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Game1A2B implements ActionListener {
  JFrame f;
  JTextField txt;                                              
  JTextArea ta;
  String msg = "";
  String answer;
  
  Game1A2B() {
    answer = init();
    System.out.println("Answer is " + answer);
    f = new JFrame("Game1A2B");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    txt = new JTextField(10);
    txt.addActionListener(this);
    c.add(txt);
    ta = new JTextArea(10,50);
    ta.setEnabled(false);
    c.add(ta);
    
    f.setSize(600,400);
    f.setVisible(true);
  }
  
  String init() {
    int a[] = {1,2,3,4,5,6,7,8,9};
    Random r = new Random();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int x = r.nextInt(9);
        int t = a[i];
        a[i] = a[x];
        a[x] = t;
      } 
    }
    return Integer.toString(a[0])+Integer.toString(a[1])+Integer.toString(a[2]);
  } 
                                                                                                                                                                
  String judge(String ans, String gue){
    int a = 0, b =0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (ans.charAt(i) == gue.charAt(j)){
          if (i == j)
            a++;
          else {
            b++;
          } 
        }
      }
    }
    return Integer.toString(a)+"A"+Integer.toString(b)+"B";
  }     
  
  public void actionPerformed(ActionEvent e) {
    String gue = txt.getText();
    String result = judge(answer, gue);
    JOptionPane.showMessageDialog(f, result);
    if (result.equals("3A0B")){
      JOptionPane.showMessageDialog(f, "You Win!");
      System.exit(0);
    } 
    msg = msg + txt.getText() + "--" + result +"\n";
    ta.setText(msg);
    txt.setText("");
  }
    
  public static void main(String[] args) {
    new Game1A2B();
  }
}