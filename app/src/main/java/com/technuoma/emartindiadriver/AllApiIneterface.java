package com.technuoma.emartindiadriver;


import com.technuoma.emartindiadriver.loginPOJO.loginBean;
import com.technuoma.emartindiadriver.ordersPOJO.ordersBean;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllApiIneterface {

    @Multipart
    @POST("emartindia/api/login3.php")
    Call<loginBean> login(
            @Part("username") String username,
            @Part("password") String password,
            @Part("token") String token
    );

    @Multipart
    @POST("emartindia/api/getOngoingDeliveries.php")
    Call<ordersBean> getOngoingDeliveries(
            @Part("id") String id
    );

}
