package bro.edwincar.tele;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by IOS - ANDROID on 13/9/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("1q2w3e4r5t6y")
                //.server("http://localhost:4040/apps/CursoAndroidios/")
                .server("http://192.168.0.100:1337/parse/")
                .enableLocalDataStore()
                .build()
        );
    }
}
