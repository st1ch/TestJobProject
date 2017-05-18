package ltd.getman.testjobproject.domain.subscribers;

import android.util.Log;
import io.reactivex.observers.DisposableObserver;

public class BaseUseCaseSubscriber<T> extends DisposableObserver<T> {
  @Override public void onComplete() {

  }

  @Override public void onError(Throwable e) {
    Log.e("Exception", String.valueOf(e));
  }

  @Override public void onNext(T t) {

  }
}
