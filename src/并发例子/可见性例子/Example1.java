package 并发例子.可见性例子;

/**
 * @author dxd
 * @date 2020/4/7
 */
public class Example1 {

  private long count = 0;

  private void add10K() {
    int idx = 0;
    while (idx++ < 10000000) {
      count += 1;
    }
  }

  public static long calc() throws InterruptedException {
    final Example1 test = new Example1();
// 创建两个线程，执行 add() 操作
    Thread th1 = new Thread(() -> {
      test.add10K();
    });
    Thread th2 = new Thread(() -> {
      test.add10K();
    });
// 启动两个线程
    th1.start();
    th2.start();
// 等待两个线程执行结束
    th1.join();
    th2.join();
    return test.count;
  }

  public static void main(String[] args) throws InterruptedException {
    long calc = calc();
    System.out.println(calc);
  }
}
