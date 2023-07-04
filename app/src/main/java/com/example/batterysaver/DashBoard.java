package com.example.batterysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {

    private TextView batteryLevelText;
    private Button forceStopButton;
    private Button batterySaverButton;
    private Button scheduleButton;
    private Button killAppsButton;
    private Button viewLogsButton;
    /*

    private RecyclerView recyclerView;
    private AppListAdapter appListAdapter;
    private List<BatteryApp> batteryAppList;
    private DBHelper dbHelper;

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        batteryLevelText = findViewById(R.id.batteryLevelText);
        forceStopButton = findViewById(R.id.forceStopButton);
        batterySaverButton = findViewById(R.id.batterySaverButton);
        scheduleButton = findViewById(R.id.scheduleButton);
        killAppsButton = findViewById(R.id.killAppsButton);
        viewLogsButton = findViewById(R.id.viewLogsButton);

        // Get battery level and display it
        int batteryLevel = getBatteryLevel();
        batteryLevelText.setText("Battery Level: " + batteryLevel + "%");

        /* inserted part
        recyclerView = findViewById(R.id.app_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DBHelper(this);
        batteryAppList = getBatteryApps();

        appListAdapter = new AppListAdapter(batteryAppList);
        recyclerView.setAdapter(appListAdapter); */

        forceStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement force stop functionality
                Toast.makeText(DashBoard.this, "Force Stop clicked", Toast.LENGTH_SHORT).show();
            }
        });

        batterySaverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement battery saver functionality
                Toast.makeText(DashBoard.this, "Battery Saver clicked", Toast.LENGTH_SHORT).show();
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement schedule functionality
                Toast.makeText(DashBoard.this, "Schedule clicked", Toast.LENGTH_SHORT).show();
            }
        });

        killAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement kill apps functionality
                Toast.makeText(DashBoard.this, "Kill Apps clicked", Toast.LENGTH_SHORT).show();
            }
        });

        viewLogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement view logs functionality
                Toast.makeText(DashBoard.this, "View Logs clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Dummy method to get battery level (replace with actual implementation)
    private int getBatteryLevel() {
        return 80;
    }

    //
    /*
    private List<BatteryApp> getBatteryApps() {
        List<BatteryApp> apps = new ArrayList<>();

        // Retrieve the battery apps using the DBHelper
        Cursor cursor = dbHelper.getAllBatteryApps();
        if (cursor.moveToFirst()) {
            do {
                String appName = cursor.getString(cursor.getColumnIndex("app_name"));
                int batteryLevel = cursor.getInt(cursor.getColumnIndex("battery_level"));
                BatteryApp batteryApp = new BatteryApp(appName, batteryLevel);
                apps.add(batteryApp);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return apps;
    }*/
}
