package com.vidyanand.fcmpushlibrary.Services;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.vidyanand.fcmpushlibrary.AppConstants.Constants;
import com.vidyanand.fcmpushlibrary.AppPrefs.FcmPrefHelper;


/**
 * Created by vidyanandmishra on 23/01/17.
 *
 * This service class will provide the device registration token for FCM
 */
public class FcmInstanceIDListenerService extends FirebaseInstanceIdService {

    private static final String TAG = "FcmInstanceIDListenerSe";

    /**
     * Every time this method will be called whenever the new Registration token
     * will be received
     */
    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.i(TAG, "onTokenRefresh: " + refreshedToken);

        FcmPrefHelper.saveFCMToken(this, refreshedToken);

        Intent intent = new Intent();
        intent.putExtra(Constants.FCM_TOKEN, refreshedToken);
        intent.setAction(Constants.RECEIVER_FILTER_REG);
        sendBroadcast(intent);
    }
}
