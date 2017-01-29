package com.vidyanand.fcmsample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.vidyanand.fcmpushlibrary.AppConstants.Constants;
import com.vidyanand.fcmpushlibrary.Models.NotificationModel;
import com.vidyanand.fcmpushlibrary.Receivers.FcmEventReceiver;

/**
 * Created by vidyanandmishra on 29/01/17.
 */

public class PushNotificationReceiver extends FcmEventReceiver {

    private static final String TAG = "PushNotificationReceive";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);


        if (intent.getAction().equals(Constants.RECEIVER_FILTER_REG)) {

            String token = intent.getStringExtra(Constants.FCM_TOKEN);
            Log.e(TAG, "onReceive: REG_TOKEN : " + token);
        } else if (intent.getAction().equals(Constants.RECEIVER_FILTER_MSG)) {

            String notificationPayload = intent.getStringExtra(Constants.NOTIFICATION_PAYLOAD_KEY);
            Log.i(TAG, "onReceive: Notification Data" + notificationPayload);

            NotificationModel notificationModel = new Gson().fromJson(notificationPayload, NotificationModel.class);

            if (notificationModel != null) {
                Log.i(TAG, "onReceive: " + notificationModel.getNotificationPayload().getFcmMessage());

                if(CommonUtils.isAppIsInBackground(context)) {
                    sendNotification(context, notificationModel);
                }
            }
        }
    }

    private void sendNotification(Context context, NotificationModel notificationModel) {

        Intent intent = new Intent(context, MainActivity.class);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(notificationModel.getNotificationPayload().getFcmTitle())
                .setContentText(notificationModel.getNotificationPayload().getFcmMessage())
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
