package bro.edwincar.tele;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by IOS - ANDROID on 25/9/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.cmpUserName)
    EditText cmp_UserName;
    @BindView(R.id.cmpUserEmail)
    EditText cmp_UserEmail;
    @BindView(R.id.cmpUserPass)
    EditText cmp_UserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRRegistrar)
    public void Registrar(View v) {
        Toast.makeText(RegisterActivity.this, "Hola asdasd", Toast.LENGTH_SHORT).show();
        if (isFormValid()) {
            ParseUser user = new ParseUser();
            user.setUsername(cmp_UserName.getText().toString());
            user.setEmail(cmp_UserEmail.getText().toString());
            user.setPassword(cmp_UserPass.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setTitle("Informacion");
                        builder.setMessage("Registro Exitoso");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                RegisterActivity.this.finish();
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();
                    }else
                        Toast.makeText(RegisterActivity.this, "Registro fallido!", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    @OnClick(R.id.btnRInicioSesion)
    public void Login(View v) {
        finish();
    }

    private boolean isFormValid() {
        CharSequence email = cmp_UserEmail.toString();
        String message = "";
        if (cmp_UserName.getText().toString().isEmpty()) {
            message = "Campo vacio";
            return false;
        }
        if (cmp_UserEmail.getText().toString().isEmpty()) {
            message = "Campo vacio";
            return false;
        }
        if (cmp_UserPass.getText().toString().length() <= 6) {
            message = "El Password debe contener mas de 6 caracteres";
            return false;
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            message = "El Email no es valido";
            return false;
        }
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
        return true;
    }

}
