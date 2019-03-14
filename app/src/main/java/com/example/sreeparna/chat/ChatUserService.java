package com.example.sreeparna.chat;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by Sreeparna on 13-03-2019.
 */

public interface ChatUserService {
    @GET("/api/user")
    Call<ChatUserResponse> user();
}
