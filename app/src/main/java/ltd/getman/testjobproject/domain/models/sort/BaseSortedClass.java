package ltd.getman.testjobproject.domain.models.sort;

import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ltd.getman.testjobproject.domain.models.mechanizm.Mechanizm;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */
@RequiredArgsConstructor
public abstract class BaseSortedClass {

  @Getter @NonNull private TYPE type;

  public abstract <T extends Mechanizm> List<T> sort(List<T> mechanizmList);

  public enum TYPE {
    BUBBLE, QUICK, INSERT
  }
}
