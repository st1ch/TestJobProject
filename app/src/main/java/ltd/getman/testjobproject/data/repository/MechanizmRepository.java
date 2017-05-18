package ltd.getman.testjobproject.data.repository;

import io.reactivex.Observable;
import java.util.List;
import ltd.getman.testjobproject.domain.models.mechanizm.Car;
import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.mechanizm.Plane;
import ltd.getman.testjobproject.domain.models.mechanizm.Ship;
import ltd.getman.testjobproject.domain.models.sort.BaseSortedClass;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public interface MechanizmRepository {
  Observable<List<Car>> getCars(int count);

  Observable<List<Plane>> getPlanes(int count);

  Observable<List<Ship>> getShips(int count);

  Observable<Data> getData(int carsCount, int planesCount, int shipsCount);

  Observable<Data> getSortedData(BaseSortedClass.TYPE sortType, int carsCount, int planesCount,
      int shipsCount);
}

