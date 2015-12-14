package r2b.apps.gnome;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        applicationContext = getApplicationContext();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
