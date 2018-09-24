package com.example.ahmedd.route;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btnLogin;
    CheckBox checkBox;
    TextInputEditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        editTextName = (TextInputEditText) findViewById(R.id.editTxtName);
        TextView regNow = findViewById(R.id.regNow);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            SharedPreferences sharedPreferences =
                    getSharedPreferences("Route", MODE_PRIVATE);
            @Override
            public void onClick(View view) {
            String userName = editTextName.getText().toString();


               String value = sharedPreferences.getString("Name" , null);

            if (value.equals(userName)){

                Intent intent = new Intent(Login.this, Survey.class);
                startActivity(intent);
            }
                else if (value != userName) {

                editTextName.setError("Invalid User Name");
            }


            }
        });


        regNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Regesteration.class);
                startActivity(intent);

            }
        });

    }
}
