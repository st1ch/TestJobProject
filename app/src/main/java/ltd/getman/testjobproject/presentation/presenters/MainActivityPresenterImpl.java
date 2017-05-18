package ltd.getman.testjobproject.presentation.presenters;

import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.sort.BaseSortedClass;
import ltd.getman.testjobproject.domain.subscribers.BaseProgressSubscriber;
import ltd.getman.testjobproject.domain.usecases.SortDataUseCase;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public class MainActivityPresenterImpl extends ProgressPresenter<MainActivityPresenter.View>
    implements MainActivityPresenter {

  private SortDataUseCase sortDataUseCase;

  public MainActivityPresenterImpl(SortDataUseCase sortDataUseCase) {
    this.sortDataUseCase = sortDataUseCase;
  }

  @Override
  public void onLoadDataClick(BaseSortedClass.TYPE sortType, int carsCount, int planesCount,
      int shipsCount) {
    sortDataUseCase.execute(loadDataSubscriber(),
        SortDataUseCase.Params.selectSortType(sortType, carsCount, planesCount, shipsCount));
  }

  @Override public void onDestroy() {
    super.onDestroy();
    sortDataUseCase.unsubscribe();
  }

  private BaseProgressSubscriber<Data> loadDataSubscriber() {
    return new BaseProgressSubscriber<Data>(this) {
      @Override public void onNext(Data data) {
        super.onNext(data);

        try {
          checkViewBound();

          if (data == null || (data.getCars().isEmpty()
              && data.getPlanes().isEmpty()
              && data.getShips().isEmpty())) {
            getView().showEmptyList();
          } else {
            getView().showSortedData(data);
          }
        } catch (ViewNotBoundException e) {
          e.printStackTrace();
        }
      }
    };
  }
}
