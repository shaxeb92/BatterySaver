// BatteryApp.java

public class BatteryApp {
    private String appName;
    private int batteryLevel;

    public BatteryApp(String appName, int batteryLevel) {
        this.appName = appName;
        this.batteryLevel = batteryLevel;
    }

    public String getAppName() {
        return appName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
