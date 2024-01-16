public class Horse2 implements Runnable {
  String name;
  
  Horse2(String name){
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
    Horse2 h1 = new Horse2("John");
    Horse2 h2 = new Horse2("Mary");
    Horse2 h3 = new Horse2("Tom");
    Horse2 h4 = new Horse2("Lena");
    
    Thread t1 = new Thread(h1);
    t1.start();
    Thread t2 = new Thread(h2);
    t2.start();
    Thread t3 = new Thread(h3);
    t3.start();
    Thread t4 = new Thread(h4);
    t4.start();
    System.out.println("Game over!\n");
  }
} 