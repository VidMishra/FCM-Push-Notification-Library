package com.vidyanand.fcmpushlibrary.Services;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.vidyanand.fcmpushlibrary.Delegates.FcmManager;
import com.vidyanand.fcmpushlibrary.Models.FCMNotificationPayload;
import com.vidyanand.fcmpushlibrary.Models.NotificationModel;

import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;


/**
 * Created by vidyanandmishra on 23/01/17.
 * Service class to receive the FCM messages {@link FcmManager}
 */
public class FcmMsgListenerService extends FirebaseMessagingService {

    private static final String TAG = "FcmMsgListenerService";

    /**
     * Called when message is received.
     *
     * @param remoteMessage
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.i(TAG, "onMessageReceived: From: " + remoteMessage.getFrom());
        Log.i(TAG, "onMessageReceived: Data: " + remoteMessage.getData().toString());

        if (remoteMessage.getData().size() > 0) {

            JSONObject object = new JSONObject(remoteMessage.getData());

            FCMNotificationPayload payload = new FCMNotificationPayload(object);

            NotificationModel notificationModel = new NotificationModel();
            notificationModel.setObjectId(UUID.randomUUID().toString());
            notificationModel.setNotificationPayload(payload);
            notificationModel.setCreatedAt(new Date());

            Log.i(TAG, "onMessageReceived: FCM " + notificationModel.getNotificationPayload().getFcmMessage());

            FcmManager.getInstance(getApplicationContext()).onMessageReceived(notificationModel);

        } else {
            Log.e(TAG, "onMessageReceived: No Data");
        }
    }
}
