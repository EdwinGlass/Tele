package bro.edwincar.tele;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by IOS - ANDROID on 25/9/2017.
 */

public class LoginActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    @BindView(R.id.editText_UserName)
    EditText cmp_UserName;

    @BindView(R.id.editText_Pass)
    EditText cmp_UserPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btbSessionRegistrar)
    public void Registrar(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @OnClick(R.id.btnSesion)
    public void Login(View v) {

    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//
//        }
//    }
}
