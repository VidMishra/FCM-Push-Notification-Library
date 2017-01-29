package com.vidyanand.fcmpushlibrary.Delegates;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.vidyanand.fcmpushlibrary.AppConstants.Constants;
import com.vidyanand.fcmpushlibrary.AppPrefs.FcmPrefHelper;
import com.vidyanand.fcmpushlibrary.Models.NotificationModel;


/**
 * Created by vidyanandmishra on 23/01/17.
 */

public class FcmManager {

    private static final String TAG = "FcmManager";

    private static FcmManager instance = null;

    private Context mContext;

    private FcmManager(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Provide singleton instance
     * @param context
     * @return FcmManager Instance
     */
    public static FcmManager getInstance(Context context) {
        if (instance == null)
            instance = new FcmManager(context);
        return instance;
    }

    /**
     * Method to listen received messages
     * @param notificationModel
     */
    public void onMessageReceived(NotificationModel notificationModel) {

        Intent intent = new Intent();

        String notification = new Gson().toJson(notificationModel);
        Log.i(TAG, "sendNotification: "+notification);

        intent.putExtra(Constants.NOTIFICATION_PAYLOAD_KEY, notification);
        intent.setAction(Constants.RECEIVER_FILTER_MSG);
        mContext.sendBroadcast(intent);
    }

    /**
     * Subscribe to topic
     * @param topicName
     */
    public void subscribeTopic(String topicName) {
        if (FcmPrefHelper.hasFCMToken(mContext)) {
            FirebaseMessaging.getInstance().subscribeToTopic(topicName);
        }
    }

    /**
     * Unsucbsribe from topic
     * @param topicName
     */
    public void unSubscribeTopic(String topicName) {
        if (FcmPrefHelper.hasFCMToken(mContext)) {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(topicName);
        }
    }
}
