package ltd.getman.testjobproject.presentation.presenters;

import ltd.getman.testjobproject.domain.subscribers.BaseProgressSubscriber;
import ltd.getman.testjobproject.presentation.views.ProgressView;

public abstract class ProgressPresenter<V extends ProgressView> extends BasePresenter<V>
        implements BaseProgressSubscriber.ProgressSubscriberListener {
    @Override
    public void onError(Throwable t) {
        try {
            checkViewBound();

            getView().hideProgress();
        } catch (ViewNotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCompleted() {
        try {
            checkViewBound();

            getView().hideProgress();
        } catch (ViewNotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStartLoading() {
        try {
            checkViewBound();

            getView().showProgress();
        } catch (ViewNotBoundException e) {
            e.printStackTrace();
        }
    }
}
