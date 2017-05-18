package ltd.getman.testjobproject.domain.models.sort;

import java.util.List;
import ltd.getman.testjobproject.domain.models.mechanizm.Mechanizm;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class InsertSort extends BaseSortedClass {
  public InsertSort() {
    super(TYPE.INSERT);
  }

  @Override public <T extends Mechanizm> List<T> sort(List<T> mechanizmList) {
    Mechanizm[] arr = (Mechanizm[]) mechanizmList.toArray();
    Mechanizm temp;
    int j;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i].compareTo(arr[i + 1]) > 0) {
        temp = arr[i + 1];
        arr[i + 1] = arr[i];
        j = i;
        while (j > 0 && 0 < temp.compareTo(arr[j - 1])) {
          arr[j] = arr[j - 1];
          j--;
        }
        arr[j] = temp;
      }
    }
    return mechanizmList;
  }
}
