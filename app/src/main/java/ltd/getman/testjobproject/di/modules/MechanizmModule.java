package ltd.getman.testjobproject.di.modules;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import ltd.getman.testjobproject.data.repository.MechanizmRepository;
import ltd.getman.testjobproject.data.repository.MechanizmRepositoryImpl;
import ltd.getman.testjobproject.data.datasource.MechanizmDataSource;
import ltd.getman.testjobproject.data.datasource.MechanizmDataSourceImpl;
import ltd.getman.testjobproject.domain.models.sort.SortUtil;
import ltd.getman.testjobproject.domain.usecases.SortDataUseCase;
import ltd.getman.testjobproject.presentation.presenters.MainActivityPresenter;
import ltd.getman.testjobproject.presentation.presenters.MainActivityPresenterImpl;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */
@Module public class MechanizmModule {

  @Singleton @Provides MechanizmDataSource provideMechanizmDataSource() {
    return new MechanizmDataSourceImpl();
  }

  @Singleton @Provides MechanizmRepository provideMechanizmRepository(
      MechanizmDataSource mechanizmDataSource, SortUtil sortUtil) {
    return new MechanizmRepositoryImpl(mechanizmDataSource, sortUtil);
  }

  @Provides MainActivityPresenter provideMainActivityPresenter(SortDataUseCase sortDataUseCase){
    return new MainActivityPresenterImpl(sortDataUseCase);
  }
}
