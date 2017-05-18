package ltd.getman.testjobproject.data.datasource;

import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ltd.getman.testjobproject.data.constants.Constants;
import ltd.getman.testjobproject.domain.models.mechanizm.Car;
import ltd.getman.testjobproject.domain.models.mechanizm.Plane;
import ltd.getman.testjobproject.domain.models.mechanizm.Ship;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class MechanizmDataSourceImpl implements MechanizmDataSource {
  @Override public Observable<List<Car>> getCars(int count) {
    return Observable.create(e -> {
      e.onNext(generateCars(count));
      e.onComplete();
    });
  }

  @Override public Observable<List<Plane>> getPlanes(int count) {
    return Observable.create(e -> {
      e.onNext(generatePlanes(count));
      e.onComplete();
    });
  }

  @Override public Observable<List<Ship>> getShips(int count) {
    return Observable.create(e -> {
      e.onNext(generateShips(count));
      e.onComplete();
    });
  }

  private List<Car> generateCars(int count) {
    List<Car> cars = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < count; i++) {
      cars.add(
          new Car("Car " + random.nextInt(), random.nextInt(Constants.Mechanizm.MAX_CAR_SPEED)));
    }
    return cars;
  }

  private List<Plane> generatePlanes(int count) {
    List<Plane> planes = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < count; i++) {
      planes.add(new Plane("Plane " + random.nextInt(),
          random.nextInt(Constants.Mechanizm.MAX_PLANE_SPEED)));
    }
    return planes;
  }

  private List<Ship> generateShips(int count) {
    List<Ship> ships = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < count; i++) {
      ships.add(
          new Ship("Ship " + random.nextInt(), random.nextInt(Constants.Mechanizm.MAX_SHIP_SPEED)));
    }
    return ships;
  }
}
