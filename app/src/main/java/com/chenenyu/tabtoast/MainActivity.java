package com.chenenyu.tabtoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

import com.chenenyu.tabtoast.core.TabToast;

public class MainActivity extends AppCompatActivity {
    private static long firstTime;

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TabToast.makeText(MainActivity.this, "选中了" + checkedId);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (firstTime + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            TabToast.makeText(MainActivity.this, "再按一次退出app");
        }
        firstTime = System.currentTimeMillis();
    }
}
