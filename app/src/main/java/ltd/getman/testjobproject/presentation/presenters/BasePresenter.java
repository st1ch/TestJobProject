package ltd.getman.testjobproject.presentation.presenters;

import android.support.annotation.Nullable;
import ltd.getman.testjobproject.presentation.views.IView;

public abstract class BasePresenter<V extends IView> implements IPresenter<V> {

  @Nullable private V view;

  @Override public void bind(V view) {
    this.view = view;
  }

  @Override public void unbind() {
    this.view = null;
  }

  @Override public void onCreate() {
  }

  @Override public void onDestroy() {
    unbind();
  }

  @Nullable public V getView() {
    return view;
  }

  protected void checkViewBound() throws ViewNotBoundException {
    if (!isViewBound()) {
      throw new ViewNotBoundException();
    }
  }

  private boolean isViewBound() {
    return view != null;
  }

  protected static class ViewNotBoundException extends Exception {
    public ViewNotBoundException() {
      super("Please call Presenter.bind(MvpView) before requesting data to the Presenter");
    }
  }
}
