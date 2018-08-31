package com.example.ahmedd.route;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

public class Survey extends AppCompatActivity {

    TextView txtBack;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

    txtBack = (TextView) findViewById(R.id.txtBack);
    spinner = (Spinner) findViewById(R.id.spinner);

    txtBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Survey.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.genders));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


    }
}
