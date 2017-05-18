package ltd.getman.testjobproject.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import ltd.getman.testjobproject.R;
import ltd.getman.testjobproject.TestJobApplication;
import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.sort.BaseSortedClass;
import ltd.getman.testjobproject.presentation.adapters.DataAdapter;
import ltd.getman.testjobproject.presentation.presenters.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

  @BindView(R.id.rv_data) RecyclerView rvData;
  @BindView(R.id.progress) ProgressBar progressBar;
  @BindView(R.id.rg_sort) RadioGroup rgSortType;
  @BindView(R.id.et_cars_count) EditText etCarsCount;
  @BindView(R.id.et_planes_count) EditText etPlanesCount;
  @BindView(R.id.et_ships_count) EditText etShipsCount;
  @BindView(R.id.empty_placeholder) View emptyPlaceholder;

  @Inject MainActivityPresenter presenter;
  @Inject DataAdapter dataAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TestJobApplication.getApplicationComponent().inject(this);
    ButterKnife.bind(this);

    initContent();
  }

  private void initContent() {
    rvData.setLayoutManager(new LinearLayoutManager(this));
    rvData.setAdapter(dataAdapter);
  }

  @Override protected void onResume() {
    super.onResume();
    presenter.bind(this);
  }

  @Override protected void onPause() {
    presenter.unbind();
    super.onPause();
  }

  @OnClick(R.id.btn_start) protected void onStartClick() {
    BaseSortedClass.TYPE type;
    switch (rgSortType.getCheckedRadioButtonId()) {
      case R.id.rb_bubble_sort:
      default:
        type = BaseSortedClass.TYPE.BUBBLE;
        break;
      case R.id.rb_quick_sort:
        type = BaseSortedClass.TYPE.QUICK;
        break;
      case R.id.rb_insertion_sort:
        type = BaseSortedClass.TYPE.INSERT;
        break;
    }

    int carsCount = Integer.valueOf(etCarsCount.getText().toString());
    int planesCount = Integer.valueOf(etPlanesCount.getText().toString());
    int shipsCount = Integer.valueOf(etShipsCount.getText().toString());

    presenter.onLoadDataClick(type, carsCount, planesCount, shipsCount);
  }

  @Override public void showSnackbarMessage(String text) {
    final Snackbar snackbar =
        Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG);
    snackbar.setAction(getResources().getString(R.string.okay), view -> snackbar.dismiss());
    snackbar.show();
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
    rvData.setVisibility(View.GONE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
    rvData.setVisibility(View.VISIBLE);
  }

  @Override public void showSortedData(Data data) {
    emptyPlaceholder.setVisibility(View.GONE);
    dataAdapter.setMechanizms(data);
  }

  @Override public void showEmptyList() {
    emptyPlaceholder.setVisibility(View.VISIBLE);
    rvData.setVisibility(View.GONE);
  }
}
