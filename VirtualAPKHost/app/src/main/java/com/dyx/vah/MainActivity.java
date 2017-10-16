package com.dyx.vah;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.didi.virtualapk.PluginManager;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_load_plugin_a)
    Button btnLoadPluginA;
    @BindView(R.id.btn_load_plugin_b)
    Button btnLoadPluginB;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_load_plugin_a, R.id.btn_load_plugin_b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_load_plugin_a:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadPlugin(Constants.PLUGIN_A_FILE_NAME);
                    }
                }).start();
                break;
            case R.id.btn_load_plugin_b:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadPlugin(Constants.PLUGIN_B_FILE_NAME);
                    }
                }).start();
                break;
        }
    }

    private void loadPlugin(String fileName) {
        PluginManager pluginManager = PluginManager.getInstance(this);
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        if (file.exists()) {
            try {
                pluginManager.loadPlugin(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
    }
}
