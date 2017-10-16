package com.dyx.vah;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;

/**
 * Author：dayongxin
 * Function：
 */
public class XApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //Init VirtualAPK PluginManager
        PluginManager.getInstance(base).init();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
