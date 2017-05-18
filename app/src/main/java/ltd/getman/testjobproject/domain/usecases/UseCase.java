package ltd.getman.testjobproject.domain.usecases;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ltd.getman.testjobproject.domain.schedulers.ObserveOn;
import ltd.getman.testjobproject.domain.schedulers.SubscribeOn;

public abstract class UseCase<T, Params> {
  private SubscribeOn subscribeOn;
  private ObserveOn observeOn;
  private CompositeDisposable disposables;
  private Observable<T> observable;

  public UseCase(SubscribeOn subscribeOn, ObserveOn observeOn) {
    this.subscribeOn = subscribeOn;
    this.observeOn = observeOn;
    this.disposables = new CompositeDisposable();
  }

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
   */
  abstract Observable<T> getUseCaseObservable(Params params);

  /**
   * Executes the current use case.
   *
   * @param observer {@link DisposableObserver} which will be listening to the observable build
   * by {@link #getUseCaseObservable(Params)} ()} method.
   * @param params Parameters (Optional) used to build/execute this use case.
   */
  public void execute(DisposableObserver<T> observer, Params params) {
    Preconditions.checkNotNull(observer);
    observable = getUseCaseObservable(params).subscribeOn(subscribeOn.getScheduler())
        .observeOn(observeOn.getScheduler())
        .cache()
        .doOnError(throwable -> observable = null)
        .doOnComplete(() -> observable = null);

    addDisposable(observable.subscribeWith(observer));
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  private void addDisposable(Disposable disposable) {
    Preconditions.checkNotNull(disposable);
    Preconditions.checkNotNull(disposables);
    disposables.add(disposable);
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  public void unsubscribe() {
    if (!disposables.isDisposed()) {
      disposables.dispose();
    }
  }
}
