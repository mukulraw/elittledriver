package com.technuoma.elittledriver;


import com.technuoma.elittledriver.deliveryDetailsPOJO.deliveryDetailsBean;
import com.technuoma.elittledriver.loginPOJO.loginBean;
import com.technuoma.elittledriver.ordersPOJO.ordersBean;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllApiIneterface {

    @Multipart
    @POST("elittleplanet/api/login3.php")
    Call<loginBean> login(
            @Part("username") String username,
            @Part("password") String password,
            @Part("token") String token
    );

    @Multipart
    @POST("elittleplanet/api/getOngoingDeliveries.php")
    Call<ordersBean> getOngoingDeliveries(
            @Part("id") String id
    );

    @Multipart
    @POST("elittleplanet/api/getCompletedDeliveries.php")
    Call<ordersBean> getCompletedDeliveries(
            @Part("id") String id
    );

    @Multipart
    @POST("elittleplanet/api/getDeliveryDetails.php")
    Call<deliveryDetailsBean> getDeliveryDetails(
            @Part("id") String id
    );

    @Multipart
    @POST("elittleplanet/api/changeDeliveryStatus.php")
    Call<deliveryDetailsBean> changeDeliveryStatus(
            @Part("id") String id,
            @Part("status") String status
    );

    @Multipart
    @POST("elittleplanet/api/addLogs.php")
    Call<deliveryDetailsBean> addLogs(
            @Part("delivery_id") String delivery_id,
            @Part("order_id") String order_id,
            @Part("lat") String lat,
            @Part("lng") String lng
    );

}
