package ltd.getman.testjobproject.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ltd.getman.testjobproject.domain.schedulers.ObserveOn;
import ltd.getman.testjobproject.domain.schedulers.SubscribeOn;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */
@Module public class ApplicationModule {

  private Context mContext;

  public ApplicationModule(Context context) {
    mContext = context;
  }

  @Provides public Context getContext() {
    return mContext;
  }

  @Provides SubscribeOn provideSubscribeOn() {
    return Schedulers::io;
  }

  @Provides ObserveOn provideObserverOn() {
    return AndroidSchedulers::mainThread;
  }
}
