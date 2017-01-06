package info.androidhive.listviewfeed.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import info.androidhive.listviewfeed.R;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int SPLASH_DISPLAY_LENGTH = 3000;

        setContentView(R.layout.activity_splash);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent i = new Intent(Splash.this, Home.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
