package com.vidyanand.fcmpushlibrary.AppPrefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.vidyanand.fcmpushlibrary.AppConstants.Constants.FCM_TOKEN;
import static com.vidyanand.fcmpushlibrary.AppConstants.Constants.TOKEN_EXISTS;

/**
 * Created by vidyanandmishra on 23/01/17.
 */

public class FcmPrefHelper {

    private FcmPrefHelper() { }

    /**
     * To store FCM Reg token {@link SharedPreferences}.
     *
     * @param context
     * @param fcmToken
     */
    public static void saveFCMToken(Context context, String fcmToken) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        pref.edit().putString(FCM_TOKEN, fcmToken).apply();
    }

    /**
     * Get FCM Token from {@link SharedPreferences}.
     *
     * @param context
     * @return String
     */
    public static String getFCMToken(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return pref.getString(FCM_TOKEN, "");
    }

    /**
     * Is token exist
     * @param context
     * @return boolean
     */
    public static boolean hasFCMToken(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return pref.getBoolean(TOKEN_EXISTS, false);
    }
}
