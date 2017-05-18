package ltd.getman.testjobproject.domain.usecases;

import io.reactivex.Observable;
import javax.inject.Inject;
import ltd.getman.testjobproject.data.repository.MechanizmRepository;
import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.sort.BaseSortedClass;
import ltd.getman.testjobproject.domain.schedulers.ObserveOn;
import ltd.getman.testjobproject.domain.schedulers.SubscribeOn;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public class SortDataUseCase extends UseCase<Data, SortDataUseCase.Params> {

  private MechanizmRepository mechanizmRepository;

  @Inject SortDataUseCase(SubscribeOn subscribeOn, ObserveOn observeOn,
      MechanizmRepository mechanizmRepository) {
    super(subscribeOn, observeOn);
    this.mechanizmRepository = mechanizmRepository;
  }

  @Override Observable<Data> getUseCaseObservable(Params params) {
    return mechanizmRepository.getSortedData(params.sortType, params.carsCount, params.planesCount,
        params.shipsCount);
  }

  public static final class Params {

    private final BaseSortedClass.TYPE sortType;
    private final int carsCount;
    private final int planesCount;
    private final int shipsCount;

    private Params(BaseSortedClass.TYPE sortType, int carsCount, int planesCount, int shipsCount) {
      this.sortType = sortType;
      this.carsCount = carsCount;
      this.shipsCount = shipsCount;
      this.planesCount = planesCount;
    }

    public static Params selectSortType(BaseSortedClass.TYPE sortType, int carsCount,
        int planesCount, int shipsCount) {
      return new Params(sortType, carsCount, planesCount, shipsCount);
    }
  }
}
