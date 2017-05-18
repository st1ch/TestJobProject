package ltd.getman.testjobproject.domain.models.mechanizm;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public class Ship extends Mechanizm {
  public Ship(String name, int highSpeed) {
    super(name, TYPE.WATER, highSpeed);
  }
}
