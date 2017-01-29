package com.vidyanand.fcmpushlibrary.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.vidyanand.fcmpushlibrary.AppConstants.Constants;

/**
 * Created by vidyanandmishra on 24/01/17.
 */

public class FcmEventReceiver extends BroadcastReceiver {

    private static final String TAG = "FcmEventReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Constants.RECEIVER_FILTER_REG)) {
            Log.i(TAG, "onReceive: fcmlibrary : REG");
        } else if (intent.getAction().equals(Constants.RECEIVER_FILTER_MSG)) {
            Log.i(TAG, "onReceive: fcmlibrary : MSG");
        }
    }
}
