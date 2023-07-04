// AppListAdapter.java

/*
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {
    private List<BatteryApp> batteryAppList;

    public AppListAdapter(List<BatteryApp> batteryAppList) {
        this.batteryAppList = batteryAppList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_battery_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BatteryApp batteryApp = batteryAppList.get(position);
        holder.appNameTextView.setText(batteryApp.getAppName());
        holder.batteryLevelTextView.setText(String.valueOf(batteryApp.getBatteryLevel()));
    }

    @Override
    public int getItemCount() {
        return batteryAppList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView appNameTextView;
        public TextView batteryLevelTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appNameTextView = itemView.findViewById(R.id.app_name);
            batteryLevelTextView = itemView.findViewById(R.id.battery_level);
        }
    }
}
*/