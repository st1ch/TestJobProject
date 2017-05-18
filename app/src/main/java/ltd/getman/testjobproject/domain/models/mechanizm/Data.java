package ltd.getman.testjobproject.domain.models.mechanizm;

import java.util.List;
import lombok.Getter;
import lombok.experimental.Builder;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */
@Builder public class Data {
  @Getter private List<Car> cars;
  @Getter private List<Plane> planes;
  @Getter private List<Ship> ships;
}
