package ltd.getman.testjobproject.domain.models.mechanizm;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */
@RequiredArgsConstructor @ToString
public abstract class Mechanizm implements Comparable<Mechanizm>{
  @Getter @NonNull private String name;
  @Getter @NonNull private TYPE type;
  @Getter @NonNull private int highSpeed;

  public enum TYPE {
    WATER, EARTH, SKY
  }

  @Override public int compareTo(@android.support.annotation.NonNull Mechanizm o) {
    return this.name.compareTo(o.name);
  }
}
