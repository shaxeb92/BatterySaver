package com.example.batterysaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {

    private TextView batteryLevelText;
    private Button forceStopButton;
    private Button batterySaverButton;
    private Button scheduleButton;
    private Button killAppsButton;
    private Button viewLogsButton;

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
}
