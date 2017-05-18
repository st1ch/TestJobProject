package ltd.getman.testjobproject.domain.subscribers;

import android.util.Log;

public class BaseProgressSubscriber<T> extends BaseUseCaseSubscriber<T> {

  private String TAG = BaseProgressSubscriber.class.getSimpleName();

  private ProgressSubscriberListener progressSubscriberListener;

  public BaseProgressSubscriber(ProgressSubscriberListener progressSubscriberListener) {
    this.progressSubscriberListener = progressSubscriberListener;
  }

  @Override public void onStart() {
    if (progressSubscriberListener != null) {
      progressSubscriberListener.onStartLoading();
    }
  }

  @Override public void onComplete() {
    if (progressSubscriberListener != null) {
      progressSubscriberListener.onCompleted();
    }
  }

  @Override public void onError(Throwable e) {
    e.printStackTrace();
    Log.e(TAG, "onError: " + e);
    if (progressSubscriberListener != null) {
      progressSubscriberListener.onError(e);
    }
    progressSubscriberListener = null;
  }

  @Override public void onNext(T t) {
    Log.i(TAG, "onNext: " + t);
  }

  public interface ProgressSubscriberListener {
    void onError(Throwable t);

    void onCompleted();

    void onStartLoading();
  }
}
