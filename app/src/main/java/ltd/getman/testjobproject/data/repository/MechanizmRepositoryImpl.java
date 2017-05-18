package ltd.getman.testjobproject.data.repository;

import io.reactivex.Observable;
import java.util.List;
import ltd.getman.testjobproject.data.datasource.MechanizmDataSource;
import ltd.getman.testjobproject.domain.models.mechanizm.Car;
import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.mechanizm.Plane;
import ltd.getman.testjobproject.domain.models.mechanizm.Ship;
import ltd.getman.testjobproject.domain.models.sort.BaseSortedClass;
import ltd.getman.testjobproject.domain.models.sort.SortUtil;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class MechanizmRepositoryImpl implements MechanizmRepository {

  private MechanizmDataSource dataSource;
  private SortUtil sortUtil;

  public MechanizmRepositoryImpl(MechanizmDataSource dataSource, SortUtil sortUtil) {
    this.dataSource = dataSource;
    this.sortUtil = sortUtil;
  }

  @Override public Observable<List<Car>> getCars(int count) {
    return dataSource.getCars(count);
  }

  @Override public Observable<List<Plane>> getPlanes(int count) {
    return dataSource.getPlanes(count);
  }

  @Override public Observable<List<Ship>> getShips(int count) {
    return dataSource.getShips(count);
  }

  @Override public Observable<Data> getData(int carsCount, int planesCount, int shipsCount) {
    return Observable.zip(dataSource.getCars(carsCount), dataSource.getPlanes(planesCount),
        dataSource.getShips(shipsCount),
        (cars, planes, ships) -> Data.builder().cars(cars).planes(planes).ships(ships).build());
  }

  @Override public Observable<Data> getSortedData(BaseSortedClass.TYPE sortType, int carsCount,
      int planesCount, int shipsCount) {
    return Observable.zip(dataSource.getCars(carsCount).compose(sortUtil.sort(sortType)),
        dataSource.getPlanes(planesCount).compose(sortUtil.sort(sortType)),
        dataSource.getShips(shipsCount).compose(sortUtil.sort(sortType)),
        (cars, planes, ships) -> Data.builder().cars(cars).planes(planes).ships(ships).build());
  }
}
