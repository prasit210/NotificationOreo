package com.example.prasit.notificationoreo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnNotification);
        notificationHelper = new NotificationHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification("GG","GG");
            }
        });

    }

    public void sendNotification(String title, String message) {
        android.support.v4.app.NotificationCompat.Builder builder = notificationHelper.getChanalNotification(title, message);
            notificationHelper.getNotificationManager().notify(1,builder.build());

    }
}
