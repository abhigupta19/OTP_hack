package com.sar.user.message_11;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentProvider;
import android.os.Build;

public class Norti extends Application {
    public static final  String channal_id="Message";
    @Override
    public void onCreate() {
        super.onCreate();
        ab();
    }
    public void ab()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel(channal_id,"Mess", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }

}
