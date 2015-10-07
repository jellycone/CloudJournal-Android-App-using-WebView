package com.nikhilraichur.journal.journal_cloud;

import android.app.Activity;
import android.content.Intent;
import android.os.*;

//import java.util.logging.Handler;
import java.util.logging.*;

/**
 * Created by NikhilRaichur on 17-03-2015.
 */
public class SplashScreen extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashlayout);

        int secondsDelayed = 4;
        new android.os.Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
