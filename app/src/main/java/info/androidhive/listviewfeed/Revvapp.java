package info.androidhive.listviewfeed;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Umme on 22-Feb-17.
 */
public class Revvapp extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
