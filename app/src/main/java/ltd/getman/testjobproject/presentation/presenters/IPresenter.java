package ltd.getman.testjobproject.presentation.presenters;

import ltd.getman.testjobproject.presentation.views.IView;

/**
 * Created by alexeyverbitskiy on 10/31/16.
 */

public interface IPresenter<V extends IView> {
    void bind(V view);
    void unbind();
    void onCreate();
    void onDestroy();
}
