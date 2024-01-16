import java.util.Random;
public class Horse3 extends Thread{
  String name;
  
  Horse3(String name){
    this.name = name;
}
  
  public void run(){
    Random r = new Random();
    for (int i = 1; i < 6; i++){
      System.out.printf("%-8s:%2d\n", name, i);
      
      try {
          Thread.sleep(r.nextInt(1000));  
      } catch(Exception e) {
        e.printStackTrace();
      }
           
    }
    System.out.printf("%8s finish!\n", name);
  }
  
  public static void main(String[] args){
    Horse3 h1 = new Horse3("John");
    Horse3 h2 = new Horse3("Mary");
    Horse3 h3 = new Horse3("Tom");
    Horse3 h4 = new Horse3("Lena");
    
    h1.start();
    h2.start();
    h3.start();
    h4.start();
    try {
      h1.join();
      h2.join();
      h3.join();
      h4.join();
    } catch(InterruptedException e) {
     e.printStackTrace(); 
    }
    System.out.println("Game over!\n");
  }
} 