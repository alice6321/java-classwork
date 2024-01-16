class Odd extends Thread {
  int maxOddNumber;
  SharedOddEven sharedResource;

  Odd(int number, SharedOddEven sharedResource) {
    this.maxOddNumber = number;
    this.sharedResource = sharedResource;
  }

  public void run() {
    int minOddNum = 1;
    try {
      while (minOddNum <= maxOddNumber) {
        sharedResource.printOddNumber(minOddNum);
        minOddNum = minOddNum + 2;
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}

class Even extends Thread {
  int maxEvenNumber;
  SharedOddEven sharedResource;

  Even(int number, SharedOddEven sharedResource) {
    this.maxEvenNumber = number;
    this.sharedResource = sharedResource;
  }

  public void run() {
    int minEvenNum = 2;
    try {
      while (minEvenNum <= maxEvenNumber) {
        sharedResource.printEvenNumber(minEvenNum);
        minEvenNum = minEvenNum + 2;
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
}

public class OddEvenNumberUsingThread {

  public static void main(String[] args) {
    
    SharedOddEven sharedResource = new SharedOddEven();
    Odd oddNum = new Odd(30, sharedResource);
    Even evenNum = new Even(30, sharedResource);
    oddNum.start();
    evenNum.start();
    
  }

}
