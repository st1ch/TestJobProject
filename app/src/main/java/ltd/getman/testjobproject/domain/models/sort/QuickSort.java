package ltd.getman.testjobproject.domain.models.sort;

import java.util.List;
import java.util.Random;
import ltd.getman.testjobproject.domain.models.mechanizm.Mechanizm;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class QuickSort extends BaseSortedClass {

  private static final Random RND = new Random();

  public QuickSort() {
    super(TYPE.QUICK);
  }

  @Override public <T extends Mechanizm> List<T> sort(List<T> mechanizmList) {
    qsort(mechanizmList, 0, mechanizmList.size() - 1);
    return mechanizmList;
  }

  private <T extends Mechanizm> void qsort(List<T> mechanizmList, int begin, int end) {
    if (end > begin) {
      int index = partition(mechanizmList, begin, end);
      qsort(mechanizmList, begin, index - 1);
      qsort(mechanizmList, index + 1, end);
    }
  }

  private <T extends Mechanizm> int partition(List<T> mechanizmList, int begin, int end) {
    int index = begin + RND.nextInt(end - begin + 1);
    Mechanizm pivot = mechanizmList.get(index);
    swap(mechanizmList, index, end);
    for (int i = index = begin; i < end; ++i) {
      if (mechanizmList.get(i).compareTo(pivot) <= 0) {
        swap(mechanizmList, index++, i);
      }
    }
    swap(mechanizmList, index, end);
    return (index);
  }

  private <T extends Mechanizm> void swap(List<T> mechanizmList, int i, int j) {
    T tmp = mechanizmList.get(i);
    mechanizmList.set(i, mechanizmList.get(j));
    mechanizmList.set(j, tmp);
  }
}
