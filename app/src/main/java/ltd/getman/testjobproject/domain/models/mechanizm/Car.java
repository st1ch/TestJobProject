package ltd.getman.testjobproject.domain.models.mechanizm;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public class Car extends Mechanizm {
  public Car(String name, int highSpeed) {
    super(name, TYPE.EARTH, highSpeed);
  }
}
