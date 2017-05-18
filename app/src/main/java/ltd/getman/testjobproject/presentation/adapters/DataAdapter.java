package ltd.getman.testjobproject.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import ltd.getman.testjobproject.R;
import ltd.getman.testjobproject.domain.models.mechanizm.Data;
import ltd.getman.testjobproject.domain.models.mechanizm.Mechanizm;

/**
 * Created by Artem Getman on 18.05.17.
 * a.e.getman@gmail.com
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

  private List<Mechanizm> mechanizms = new ArrayList<>();
  private Context context;

  @Inject public DataAdapter(Context context) {
    this.context = context;
  }

  @Override public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new DataViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_data, parent, false));
  }

  @Override public void onBindViewHolder(DataViewHolder holder, int position) {
    Mechanizm mechanizm = getItem(position);

    holder.tvName.setText(mechanizm.getName());
    holder.tvSpeed.setText(context.getString(R.string.format_speed, mechanizm.getHighSpeed()));
    holder.tvType.setText(context.getString(R.string.format_type, mechanizm.getType().toString()));
  }

  @Override public int getItemCount() {
    return mechanizms.size();
  }

  private Mechanizm getItem(int position) {
    return mechanizms.get(position);
  }

  public void setMechanizms(Data data) {
    this.mechanizms.clear();
    this.mechanizms.addAll(data.getCars());
    this.mechanizms.addAll(data.getPlanes());
    this.mechanizms.addAll(data.getShips());
    notifyDataSetChanged();
  }

  class DataViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.tv_speed) TextView tvSpeed;
    @BindView(R.id.tv_type) TextView tvType;

    public DataViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
