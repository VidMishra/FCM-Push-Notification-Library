package com.vidyanand.fcmpushlibrary.Models;

import android.content.Intent;
import android.text.TextUtils;

import com.vidyanand.fcmpushlibrary.AppConstants.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by vidyanandmishra on 23/01/17.
 */

public class FCMNotificationPayload {

    JSONObject mPayload = null;

    public static FCMNotificationPayload createPayload(Intent intent) {
        try {
            JSONObject payload = new JSONObject(intent.getExtras().getString(Constants.PushNotification.payload));
            return new FCMNotificationPayload(payload);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FCMNotificationPayload(final JSONObject payload) {
        mPayload = payload;
    }

    public final JSONObject getPayload() {
        return mPayload;
    }

    public String getMessage() {
        try {
            return mPayload.getString(Constants.PushNotification.alert);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isDialog() {
        if (mPayload.has(Constants.PushNotification.dialog)) {
            return (getInt(Constants.PushNotification.dialog) == 1) ? (true) : (false);
        } else {
            return false;
        }
    }

    /*!
     * Returns true if notification has an action.
     */
    public boolean hasAction() {
        return mPayload.has(Constants.PushNotification.action);
    }

    /*!
     * Returns action URI if exists. Else null.
     */
    public URI getActionURI() {
        if (hasAction()) {
            try {
                return new URI(mPayload.getString(Constants.PushNotification.action));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    /*!
     * Returns action if exists. Else null.
     */
    public String getAction() {
        final URI uri = getActionURI();
        if (uri != null) {
            return uri.getScheme();
        } else {
            return null;
        }
    }

    /*!
     * Returns action data if exists. Else null.
     */
    public String getActionData() {
        final URI uri = getActionURI();

        if (uri != null && uri.getSchemeSpecificPart() != null) {
            return uri.getSchemeSpecificPart();
        } else {
            return null;
        }
    }

    public String getPushHash() {
        try {
            return mPayload.getString("push_hash");
        } catch (JSONException e) {
            return null;
        }
    }

    public String getObjectId() {
        try {
            return mPayload.getString(Constants.PushNotification.objectId);
        } catch (JSONException e) {
            return null;
        }
    }

    public int getType() {
        return getInt(Constants.PushNotification.type);
    }

    protected int getInt(final String key) {
        try {
            return mPayload.getInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected String getPayloadPart(String key) {
        try {
            return mPayload.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    // new methods

    final String CLOUDINARY_TRANSFORM_URL = "http://res.cloudinary.com/demo/image/fetch/";

    public String getFCMThumbnailImageUrl() {
        try {
            String imageUrl = mPayload.getString("img_url");
            if (!TextUtils.isEmpty(imageUrl)) {
                return CLOUDINARY_TRANSFORM_URL + "w_64,h_64/" + imageUrl;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFcmDefaultImageUrl() {
        try {
            String imageUrl = mPayload.getString("img_url");
            if (!TextUtils.isEmpty(imageUrl)) {
                return CLOUDINARY_TRANSFORM_URL + "w_256,h_256/" + imageUrl;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFcmTitle() {
        try {
            return mPayload.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getFcmMessage() {
        try {
            return mPayload.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getFcmType() {
        try {
            return mPayload.getString("type");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getCallToAction() {
        return null;
    }
}
