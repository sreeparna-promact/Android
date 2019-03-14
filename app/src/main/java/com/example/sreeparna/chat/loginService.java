package com.example.sreeparna.chat;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Sreeparna on 13-03-2019.
 */

public interface loginService {
    @POST("/api/user/login")
    Call<login> login(@Body User user);

}
