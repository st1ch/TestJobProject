package ltd.getman.testjobproject.domain.models.sort;

import io.reactivex.ObservableTransformer;
import java.util.List;
import javax.inject.Inject;
import ltd.getman.testjobproject.domain.models.mechanizm.Mechanizm;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class SortUtil {

  @Inject public SortUtil() {
  }

  public <T extends Mechanizm> ObservableTransformer<List<T>, List<T>> sort(
      BaseSortedClass.TYPE sortType) {
    return upstream -> upstream.map(mechanizmList -> getSortedClass(sortType).<T>sort(mechanizmList));
  }

  private BaseSortedClass getSortedClass(BaseSortedClass.TYPE type) {
    switch (type) {
      case BUBBLE:
      default:
        return new BubbleSort();
      case INSERT:
        return new InsertSort();
      case QUICK:
        return new QuickSort();
    }
  }
}
