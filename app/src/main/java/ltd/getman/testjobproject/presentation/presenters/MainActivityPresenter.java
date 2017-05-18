package ltd.getman.testjobproject.presentation.presenters;

import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.sort.BaseSortedClass;
import ltd.getman.testjobproject.presentation.views.ProgressView;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public interface MainActivityPresenter extends IPresenter<MainActivityPresenter.View> {

  void onLoadDataClick(BaseSortedClass.TYPE sortType, int carsCount, int planesCount,
      int shipsCount);

  interface View extends ProgressView {
    void showSortedData(Data data);
    void showEmptyList();
  }
}
