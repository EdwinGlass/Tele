package bro.edwincar.tele;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public String _nombre, _sexo, _createdAt, _updateAt, _obtectId;


    @BindView(R.id.textViewNombre)
    TextView tv_nombre;
    @BindView(R.id.textViewSexo)
    TextView tv_sexo;
    @BindView(R.id.textViewCreated)
    TextView tv_Created;
    @BindView(R.id.textViewUpdate)
    TextView tv_Updated;
    @BindView(R.id.textViewObjectId)
    TextView tv_ObjectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //traeObject("VwJhro4YBf");
        //traerObjectoLoacal();
        //insertObjct();
        traerList();
    }

    public void insertObjct() {
        final ParseObject person = new ParseObject("Persona");
        person.put("Nombre", "Edwin Higberto");
        person.put("Sexo", "Masculino");
        person.saveEventually(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.i("Objecto", person.getObjectId());
            }
        });
        person.pinInBackground();


//        person.put("direccion", "Av. Chiquiago");
//        person.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e != null) {
//                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
//                }
//                //e.printStackTrace();
//            }
//        });
//        person.unpinInBackground();//Desconectarlo
//        person.pinInBackground(); //Conectarlo
    }

    private void traeObject(String objectId) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Persona");
        query.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    _nombre = object.getString("Nombre");
                    _sexo = object.getString("Sexo");

                    _createdAt = object.getString("createdAt");
                    _updateAt = object.getString("updatedAt");
                    _obtectId = object.getString("objectId");

                    tv_nombre.setText(_nombre);
                    tv_sexo.setText(_sexo);
                    tv_Created.setText(_createdAt);
                    tv_Updated.setText(_updateAt);
                    tv_ObjectId.setText(_obtectId);
                } else {

                }
            }
        });
    }

    public void traerObjectoLoacal() {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Persona");
        query.fromLocalDatastore();
        query.getInBackground("VwJhro4YBf", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    _nombre = object.getString("Nombre");
                    _sexo = object.getString("Sexo");

                    _createdAt = object.getString("createdAt");
                    _updateAt = object.getString("updatedAt");
                    _obtectId = object.getString("objectId");

                    tv_nombre.setText(_nombre);
                    tv_sexo.setText(_sexo);
                    tv_Created.setText(_createdAt);
                    tv_Updated.setText(_updateAt);
                    tv_ObjectId.setText(_obtectId);
                }
            }
        });
    }

    public void traerList() {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Persona");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                for (ParseObject objectItem : objects) {
                    tv_nombre.setText(objectItem.getString("Nombre"));
                    tv_sexo.setText(objectItem.getString("Sexo"));
                    tv_Created.setText(objectItem.getCreatedAt().toString());
                    tv_Updated.setText(objectItem.getUpdatedAt().toString());
                    tv_ObjectId.setText(objectItem.getObjectId().toString());
                }
            }
        });
    }
}
