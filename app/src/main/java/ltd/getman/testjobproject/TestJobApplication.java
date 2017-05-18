package ltd.getman.testjobproject;

import android.app.Application;
import ltd.getman.testjobproject.di.components.ApplicationComponent;
import ltd.getman.testjobproject.di.components.DaggerApplicationComponent;
import ltd.getman.testjobproject.di.modules.ApplicationModule;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */

public class TestJobApplication extends Application {
  private static ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    applicationComponent = DaggerApplicationComponent.builder().
        applicationModule(new ApplicationModule(getApplicationContext())).build();
  }

  public static ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
