public class Horse1 extends Thread{
  String name;
  
  Horse1(String name){
    this.name = name;
  }
  
  public void run(){
    for (int i = 1; i < 6; i++){
      System.out.printf("%8s:%2d\n", name, i);  
      try {
          Thread.sleep(100);  
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
    System.out.printf("%8s finish!\n", name);
  }
  
  public static void main(String[] args){
    Horse1 h1 = new Horse1("John");
    Horse1 h2 = new Horse1("Mary");
    Horse1 h3 = new Horse1("Tom");
    Horse1 h4 = new Horse1("Lena");
    
    h1.start();
    h2.start();
    h3.start();
    h4.start();
    System.out.println("Game over!\n");
  }
} 