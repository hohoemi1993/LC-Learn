package lc381O1时间插入删除和获取随机元素;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {

  private HashMap<Integer, Set<Integer>> indexMap;

  private ArrayList<Integer> elements;

  private Random random = new Random();

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    indexMap = new HashMap<>();
    elements = new ArrayList<>();
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    elements.add(val);
    Set<Integer> indexSet = indexMap.get(val);
    if (Objects.isNull(indexSet)) {
      indexSet = new HashSet<>();
      indexSet.add(elements.size() - 1);
      indexMap.put(val, indexSet);
      return true;
    } else {
      indexSet.add(elements.size() - 1);
      return false;
    }
  }

  /** Removes a value from the collection.
   * Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    Set<Integer> indexSet = indexMap.get(val);
    if (Objects.isNull(indexSet)) {
      return false;
    }
    // 获取一个元素在elements的下标
    Integer index = indexSet.iterator().next();
    int lastIndex = elements.size() - 1;

    // 交换的时候  index对应关系发生了变化
    Integer lastElement = elements.get(lastIndex);
    Set<Integer> lastIndexSet = indexMap.get(lastElement);
    // 删除下标记录
    lastIndexSet.remove(lastIndex);
    indexSet.remove(index);
    elements.set(index, elements.get(lastIndex));
    if (index != lastIndex) {
      lastIndexSet.add(index);
    }
    if (indexSet.size() == 0) {
      indexMap.remove(val);
    }
    // 删除元素
    elements.remove(lastIndex);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    int last = elements.size();
    int i = random.nextInt(last);
    return elements.get(i);
  }

  public static void main(String[] args) {
    RandomizedCollection collection = new RandomizedCollection();

    collection.insert(0);
    collection.remove(0);
    collection.insert(-1);
    collection.remove(0);

    collection.insert(4);
    collection.insert(3);
    collection.insert(4);
    collection.insert(2);
    collection.insert(4);

    collection.remove(4);
    collection.remove(3);
    collection.remove(4);
    collection.remove(4);

    System.out.println(collection.getRandom());
    System.out.println(collection.getRandom());
    System.out.println(collection.getRandom());
    System.out.println(collection.getRandom());
    System.out.println(collection.getRandom());

  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */