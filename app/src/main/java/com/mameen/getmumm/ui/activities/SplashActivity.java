package com.mameen.getmumm.ui.activities;

import android.os.Bundle;
import android.os.Handler;

import com.mameen.getmumm.R;
import com.mameen.getmumm.util.ParentActivity;

public class SplashActivity extends ParentActivity {

    static final String TAG = SplashActivity.class.getSimpleName();

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                SplashActivity.this.gotoActivity(DashboardActivity.class);
                SplashActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
