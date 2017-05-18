package ltd.getman.testjobproject.di.components;

import dagger.Component;
import javax.inject.Singleton;
import ltd.getman.testjobproject.di.modules.ApplicationModule;
import ltd.getman.testjobproject.di.modules.MechanizmModule;
import ltd.getman.testjobproject.presentation.activities.MainActivity;

/**
 * Created by Artem Getman on 17.05.17.
 * a.e.getman@gmail.com
 */
@Singleton @Component(modules = { ApplicationModule.class, MechanizmModule.class })
public interface ApplicationComponent {
  void inject(MainActivity mainActivity);
}
