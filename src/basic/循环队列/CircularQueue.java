package basic.循环队列;

/**
 * 队空判断 head=tail
 * 队满判断 (tail+1) % n = head
 *
 * @author dxd
 * @date 2020/1/7
 */
public class CircularQueue {

  private int[] data;
  private int n;
  private int head;
  private int tail;

  public CircularQueue(int size) {
    this.data = new int[size];
    this.n = size;
    head = 0;
    tail = 0;
  }

  public void enqueue(int element) {
    // 如果队列满了则抛出异常
    if ( (tail+1) % n == head ) {
      throw new RuntimeException("队列满了");
    }
    data[tail] = element;
    tail =(tail+1) % n;
  }

  public int dequeue() {
    // 如果队列空则抛出异常
    if (head == tail) {
      throw new RuntimeException("队列空");
    }
    int result = data[head];
    head = (head + 1) % n;
    return result;
  }

}
