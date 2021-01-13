package com.technuoma.elittledriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.technuoma.elittledriver.loginPOJO.loginBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Login extends AppCompatActivity {

    Button submit;

    EditText email, pass;

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        submit = findViewById(R.id.submit);

        progress = findViewById(R.id.progress);

        email = findViewById(R.id.email);

        pass = findViewById(R.id.password);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String u = email.getText().toString();
                String p = pass.getText().toString();

                if (u.length() > 0) {
                    if (p.length() > 0) {

                        progress.setVisibility(View.VISIBLE);

                        Bean b = (Bean) getApplicationContext();

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(b.baseurl)
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

                        Log.d("asdas", SharePreferenceUtils.getInstance().getString("token"));

                        Call<loginBean> call = cr.login(u, p, SharePreferenceUtils.getInstance().getString("token"));

                        call.enqueue(new Callback<loginBean>() {
                            @Override


                            public void onResponse(Call<loginBean> call, Response<loginBean> response) {


                                if (response.body().getStatus().equals("1")) {

                                    SharePreferenceUtils.getInstance().saveString("id", response.body().getData().getId());
                                    SharePreferenceUtils.getInstance().saveString("name", response.body().getData().getName());
                                    SharePreferenceUtils.getInstance().saveString("username", response.body().getData().getUsername());
                                    SharePreferenceUtils.getInstance().saveString("type", response.body().getData().getTyp());

                                    Intent i = new Intent(Login.this, MainActivity2.class);
                                    startActivity(i);
                                    finishAffinity();


                                }

                                Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                progress.setVisibility(View.GONE);

                            }

                            @Override
                            public void onFailure(Call<loginBean> call, Throwable t) {
                                progress.setVisibility(View.GONE);
                            }
                        });

                    } else {
                        Toast.makeText(Login.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Invalid username", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}