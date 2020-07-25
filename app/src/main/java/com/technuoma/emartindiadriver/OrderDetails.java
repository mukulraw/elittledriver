package com.technuoma.emartindiadriver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity {

    Toolbar toolbar;
    ProgressBar progress;
    TextView txn , date , status , name , address , amount , pay , slot , deldate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        toolbar = findViewById(R.id.toolbar2);
        progress = findViewById(R.id.progressBar2);
        txn = findViewById(R.id.textView27);
        date = findViewById(R.id.textView28);
        status = findViewById(R.id.textView35);
        name = findViewById(R.id.textView32);
        address = findViewById(R.id.textView34);
        amount = findViewById(R.id.textView30);
        pay = findViewById(R.id.textView40);
        slot = findViewById(R.id.textView62);
        deldate = findViewById(R.id.textView42);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Order Details");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

    }
}