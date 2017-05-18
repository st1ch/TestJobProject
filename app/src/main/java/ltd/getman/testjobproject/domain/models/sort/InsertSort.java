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
    T temp;
    int j;
    for (int i = 0; i < mechanizmList.size() - 1; i++) {
      if (mechanizmList.get(i).compareTo(mechanizmList.get(i + 1)) > 0) {
        temp = mechanizmList.get(i + 1);
        mechanizmList.set(i + 1, mechanizmList.get(i));
        j = i;
        while (j > 0 && 0 < temp.compareTo(mechanizmList.get(j - 1))) {
          mechanizmList.set(j, mechanizmList.get(j - 1));
          j--;
        }
        mechanizmList.set(j, temp);
      }
    }
    return mechanizmList;
  }
}
