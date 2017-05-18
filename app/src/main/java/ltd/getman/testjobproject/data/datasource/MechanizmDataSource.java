package ltd.getman.testjobproject.data.datasource;

import io.reactivex.Observable;
import java.util.List;
import ltd.getman.testjobproject.domain.models.mechanizm.Car;
import ltd.getman.testjobproject.domain.models.mechanizm.Plane;
import ltd.getman.testjobproject.domain.models.mechanizm.Ship;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public interface MechanizmDataSource {
  Observable<List<Car>> getCars(int count);

  Observable<List<Plane>> getPlanes(int count);

  Observable<List<Ship>> getShips(int count);
}
