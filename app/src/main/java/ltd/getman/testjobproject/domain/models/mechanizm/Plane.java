package ltd.getman.testjobproject.domain.models.mechanizm;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public class Plane extends Mechanizm {
  public Plane(String name, int highSpeed) {
    super(name, TYPE.SKY, highSpeed);
  }
}
