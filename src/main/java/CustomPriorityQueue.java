import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomPriorityQueue<T> {

  List<T> items;
  private Comparator<T> comparator;
  public CustomPriorityQueue(Comparator<T> comparator) {
    this.items = new ArrayList<>();
    this.comparator = comparator;
  }

  public void add(T item) {
    if (items.isEmpty()) {
      items.add(item);
    } else {
      int queueSize = items.size();
      boolean inserted = false;
      int i=0;
      while (i < queueSize && !inserted) {
        if (comparator.compare(item, items.get(i)) < 0) {
          items.add(i, item);
          inserted = true;
        } else {
          i++;
        }
      }
      if (!inserted) {
        items.add(item);
      }
    }
  }

  public T remove() {
    return items.remove(0);
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public List<T> getStudents() {
    return items;
  }
}

