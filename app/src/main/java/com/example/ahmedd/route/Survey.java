package com.example.ahmedd.route;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ahmedd.route.MyDataBase.Model.Todo;
import com.example.ahmedd.route.MyDataBase.TodoDataBase;

public class Survey extends AppCompatActivity {

    TextView txtBack;
    Spinner spinner;
    Button next;
    Button btnShow;
    TextInputEditText editTxt_name;
    TextInputEditText editTxt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

    txtBack = (TextView) findViewById(R.id.txtBack);
    spinner = (Spinner) findViewById(R.id.spinner);
    btnShow = (Button) findViewById(R.id.btnShow);
    next = (Button) findViewById(R.id.btnAdd);
    editTxt_name = (TextInputEditText) findViewById(R.id.editTxt_name);
    editTxt_phone = (TextInputEditText) findViewById(R.id.editTxt_phone);

    txtBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    });


    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String name = editTxt_name.getText().toString();
            String phone = editTxt_phone.getText().toString();
            String gender = spinner.getSelectedItem().toString();

            Todo todo = new Todo("Name: " + name,"Gender: " +gender,"Mobile: " + phone);
            TodoDataBase.getInstance(getApplicationContext()).todoDAO().addItemTodo(todo);


        }
    });

    btnShow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Survey.this,UsersView.class);
            startActivity(intent);
            finish();
        }
    });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Survey.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.genders));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


    }
}
