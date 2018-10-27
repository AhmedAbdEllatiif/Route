package com.example.ahmedd.route;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ahmedd.route.API.APIManger;
import com.example.ahmedd.route.API.Login.Login;
import com.example.ahmedd.route.Base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private Button btnLogin;
    private TextInputEditText editTxtInputModerator;
    private TextInputEditText editTxtInputPass;
    private String userName;
    private String password;
    private final String unAutherized = "Name or Password incorrect";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        editTxtInputModerator = findViewById(R.id.editTextModerator);
        editTxtInputPass = findViewById(R.id.editTextPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = editTxtInputModerator.getText().toString();
                password = editTxtInputPass.getText().toString();

                if (isValidateLogin(userName, password)) {
                    getApi(userName, password);
                }
                /*Intent intent = new Intent(LoginActivity.this, Survey.class);
                startActivity(intent);*/
            }
        });

    }

    private void getApi(String userName, String password) {

        APIManger.getServices().login(userName, password)
            .enqueue(new Callback<Login>() {
                @Override
                public void onResponse(@NonNull Call<Login> call, @NonNull Response<Login> response) {

                    checkConnectivity(response.code());

                    if (response.body().getStatus() != null) {
                        String status = response.body().getStatus();
                        Log.e("Status", status);

                        if (status.equals("success")) {
                            //do what you want
                            showMessage("Api", "succes");
                        }
                        else if(status.equals("fail")) {
                            //Moderator or Password incorrect
                            Toast.makeText(LoginActivity.this, unAutherized, Toast.LENGTH_LONG).show();
                            editTxtInputModerator.requestFocus();
                        }
                    }
                    else {
                        Log.e("Status", "null");
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Login> call, @NonNull Throwable t) {
                    showMessage("Api", t.getMessage());

                }
            });
    }

    private Boolean isValidateLogin(String userName, String password) {
        if (userName == null || userName.trim().length() == 0) {
            editTxtInputModerator.setError("Please Enter Moderator Name");
            return false;
        }
        if (password == null  || password.trim().length() == 0) {
            editTxtInputPass.setError("Please Enter Password");
            return false;
        }
        return true;
    }

    private void checkConnectivity(int responseCode) {

        switch (responseCode) {
            case (200):
                Log.e("Code 200", "Success");
                break;
            case (400):
                Log.e("Error 400", "Bad Request");
                break;

            case (401):
                Log.e("Error 401", "Unauthorized");
                break;

            case (403):
                Log.e("Error 403", "Forbidden");
                break;

            case (404):
                Log.e("Error 404", "not Found");
                break;

            case (409):
                Log.e("Error 409", "Confilct");
                break;

            case (500):
                Log.e("Error 500", "500 Internal Server Error");
                break;
        }
    }
}
