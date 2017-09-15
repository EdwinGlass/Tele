package bro.edwincar.tele;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject person = new ParseObject("Personal");
        person.put("nombre", "Edwin Higberto");
        person.put("telefono", 61202510);
        person.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } else
                    e.printStackTrace();
            }
        });


    }
}
