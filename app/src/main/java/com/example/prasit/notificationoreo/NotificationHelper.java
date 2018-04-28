package com.example.prasit.notificationoreo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String chanelid1 = "CH ID 1";
    public static final String chanelname1 = "CH NAME 1";
    private NotificationManager notificationManager;
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChanel();
        }

    }
    @TargetApi(Build.VERSION_CODES.O)
    public void createChanel() {
        NotificationChannel channel = new NotificationChannel(chanelid1,
                chanelname1,
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(true);
        channel.enableVibration(true);
        channel.setLightColor(R.color.colorPrimary);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getNotificationManager().createNotificationChannel(channel);
    }

    public NotificationManager getNotificationManager() {
        if (notificationManager == null){
            notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public NotificationCompat.Builder getChanalNotification(String title, String messange){
        return new NotificationCompat.Builder(getApplicationContext(),chanelid1)
                .setContentTitle(title).setContentText(messange).setSmallIcon(R.mipmap.ic_launcher);
    }
}
