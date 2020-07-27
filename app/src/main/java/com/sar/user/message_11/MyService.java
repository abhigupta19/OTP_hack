package com.sar.user.message_11;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.transition.Visibility;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyService extends Service {
    public MyService() {
    }
    private static final int NOTIF_ID = 1;
    private static final String NOTIF_CHANNEL_ID = "Channel_Id";



    @Override
    public IBinder onBind(Intent intent) {
      return  null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("jjjj","onstart");
        Intent nor=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,nor,0);
        Notification notification=new NotificationCompat.Builder(this,"Message").setContentTitle("example").setContentIntent(pendingIntent).build();
        startForeground(1,notification);
        return START_NOT_STICKY;
    }

     
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("jjjj","onstop");
    }

}
