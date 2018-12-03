package com.example.mari_.pymescontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mari_.pymescontrol.tools.HttpRequest;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;
import com.example.mari_.pymescontrol.tools.PostCalls;

public class ActivityLogIn extends AppCompatActivity {
    Button loginBtn;
    EditText correo;
    EditText password;
    TextView incorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = findViewById(R.id.login_btn);
        correo = findViewById(R.id.login_correo);
        password = findViewById(R.id.login_pswd);
        incorrecto = findViewById(R.id.login_incorrecto);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostCalls.login(ActivityLogIn.this, correo.getText().toString(), password.getText().toString(), new HttpRequestResponse() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("http", response);
                        if(!response.equals("false")){
                            HttpRequest.token = response;
                            Intent intent = new Intent(ActivityLogIn.this, ActivityMain.class);
                            startActivity(intent);
                            finish();
                        }else{
                            incorrecto.setVisibility(View.VISIBLE);
                            Animation shake = AnimationUtils.loadAnimation(ActivityLogIn.this, R.anim.shaketext);
                            incorrecto.startAnimation(shake);
                        }
                    }
                });
            }
        });
    }
}