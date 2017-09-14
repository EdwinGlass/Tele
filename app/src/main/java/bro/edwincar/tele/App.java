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
                .applicationId("Edwi64asdzxc654sda")
                .server("http://localhost:4040/apps/CursoAndroidios/")
                //.server("http://localhost:1337/parse/")
                .build()
        );
    }
}
