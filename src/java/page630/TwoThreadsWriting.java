package page630;

import java.util.*;
import java.util.concurrent.*;

public class TwoThreadsWriting {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(2); //pool with 2 threads
    Data data = new Data();
    threadPool.execute(() -> addLetterToData('a', data));
    threadPool.execute(() -> addLetterToData('A', data));
    threadPool.shutdown();
  }

  private static void addLetterToData(char letter, Data data) {
    for (int i = 0; i < 26; i++) {
      data.addLetter(letter++);
      try {
        Thread.sleep(50);
      } catch (InterruptedException ignored) {}
    }
    System.out.println(Thread.currentThread().getName() + data.getLetters());
    System.out.println(Thread.currentThread().getName()
                                + " size = " + data.getLetters().size());
  }
}

final class Data {
  private final List<String> letters = new CopyOnWriteArrayList<>(); //change to CopyOnWriteArrayList

  public List<String> getLetters() {return letters;}

  public void addLetter(char letter) { //add "synchronized"
    letters.add(String.valueOf(letter));
  }
}