public class SharedOddEven {

 	boolean printOddNumberFlag = false;

 	public synchronized void printOddNumber(int number) throws InterruptedException {
  		while (printOddNumberFlag) {
   			wait();
  		}
  		printOddNumberFlag = true;
  		Thread.currentThread().setName("Odd Thread ::");
  		System.out.println(Thread.currentThread().getName() + " " + number);
  		notify();
 	}

 	public synchronized void printEvenNumber(int number) throws InterruptedException {
  		while (!printOddNumberFlag) {
   			wait();
  		}
  		printOddNumberFlag = false;
  		Thread.currentThread().setName("Even Thread ::");
  		System.out.println(Thread.currentThread().getName() + " " + number);
  		notify();
 	}
}
