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
    Mechanizm[] array = (Mechanizm[]) mechanizmList.toArray();
    qsort(array, 0, array.length - 1);
    return mechanizmList;
  }

  private void qsort(Mechanizm[] array, int begin, int end) {
    if (end > begin) {
      int index = partition(array, begin, end);
      qsort(array, begin, index - 1);
      qsort(array, index + 1, end);
    }
  }

  private int partition(Mechanizm[] array, int begin, int end) {
    int index = begin + RND.nextInt(end - begin + 1);
    Mechanizm pivot = array[index];
    swap(array, index, end);
    for (int i = index = begin; i < end; ++i) {
      if (array[i].compareTo(pivot) <= 0) {
        swap(array, index++, i);
      }
    }
    swap(array, index, end);
    return (index);
  }

  private void swap(Mechanizm[] array, int i, int j) {
    Mechanizm tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
