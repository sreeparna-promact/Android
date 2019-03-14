package com.example.sreeparna.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sreeparna on 13-03-2019.
 */

public class ChatUserResponse {
    ChatUser user=new ChatUser();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(" https://chat.promactinfo.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    ChatUserService service=retrofit.create(ChatUserService.class);
                service.user(user).enqueue(new Callback<login>() {
        @Override
        public void onResponse(Call<login> call, Response<login> response){
            if (response.isSuccessful()) {
                Log.d("response", response.body().token);
                String token = response.body().token;

                SharedPreferences preferences = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
            }
        }