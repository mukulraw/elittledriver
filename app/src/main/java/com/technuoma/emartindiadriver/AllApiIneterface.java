package com.technuoma.emartindiadriver;


import com.technuoma.emartindiadriver.deliveryDetailsPOJO.deliveryDetailsBean;
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

    @Multipart
    @POST("emartindia/api/getCompletedDeliveries.php")
    Call<ordersBean> getCompletedDeliveries(
            @Part("id") String id
    );

    @Multipart
    @POST("emartindia/api/getDeliveryDetails.php")
    Call<deliveryDetailsBean> getDeliveryDetails(
            @Part("id") String id
    );

    @Multipart
    @POST("emartindia/api/changeDeliveryStatus.php")
    Call<deliveryDetailsBean> changeDeliveryStatus(
            @Part("id") String id,
            @Part("status") String status
    );

    @Multipart
    @POST("emartindia/api/addLogs.php")
    Call<deliveryDetailsBean> addLogs(
            @Part("delivery_id") String delivery_id,
            @Part("order_id") String order_id,
            @Part("lat") String lat,
            @Part("lng") String lng
    );

}
