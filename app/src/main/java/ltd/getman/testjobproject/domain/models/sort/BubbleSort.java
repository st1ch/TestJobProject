package ltd.getman.testjobproject.domain.models.sort;

import java.util.List;
import ltd.getman.testjobproject.domain.models.mechanizm.Mechanizm;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class BubbleSort extends BaseSortedClass {

  public BubbleSort() {
    super(TYPE.BUBBLE);
  }

  @Override public <T extends Mechanizm> List<T> sort(List<T> mechanizmList) {
    for (int i = mechanizmList.size() - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (mechanizmList.get(j).compareTo(mechanizmList.get(j + 1)) > 0) {
          T t = mechanizmList.get(j);
          mechanizmList.set(j, mechanizmList.get(j + 1));
          mechanizmList.set(j + 1, t);
        }
      }
    }
    return mechanizmList;
  }
}
