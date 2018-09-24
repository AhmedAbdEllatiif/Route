package com.example.ahmedd.route;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Regesteration extends AppCompatActivity {

    EditText regName;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regesteration);

        regName = findViewById(R.id.regName);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (regName.getText().toString().trim().length() == 0){
                    regName.setError("Enter a Name");
                }
                else{
                    SharedPreferences.Editor editor =
                            getSharedPreferences("Route", MODE_PRIVATE).edit();

                    String name = regName.getText().toString();
                    editor.putString("Name", name);
                    editor.apply();

                }

            }
        });
    }
}
