package com.example.sreeparna.chat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public EditText text1,text2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn=(Button)findViewById(R.id.login) ;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edt=(EditText) findViewById(R.id.EditText2);
                User user=new User();
                user.name=edt.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(" https://chat.promactinfo.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                loginService service=retrofit.create(loginService.class);
                service.login(user).enqueue(new Callback<login>() {
                    @Override
                    public void onResponse(Call<login> call, Response<login> response) {
                        if(response.isSuccessful())
                        {
                            Log.d("response",response.body().token);
                           String token=response.body().token;

                            SharedPreferences preferences = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
                            preferences.edit().putString("TOKEN",token).apply();

                            LoginActivity lg=new LoginActivity();
                            Intent intent=new Intent(getApplicationContext(),ChatAreaActivity.class);

                            startActivity(intent);

                        }
                        else{
                            Log.d("response",response.errorBody().toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<login> call, Throwable t) {
                        Log.d("response","Failed");

                    }
                });


            }
        });


    }


}
