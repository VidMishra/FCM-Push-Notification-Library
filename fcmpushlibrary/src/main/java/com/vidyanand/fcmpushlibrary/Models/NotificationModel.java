package com.vidyanand.fcmpushlibrary.Models;

import com.vidyanand.fcmpushlibrary.AppConstants.Constants;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vidyanandmishra on 23/01/17.
 */

public class NotificationModel implements Serializable {

    private FCMNotificationPayload mPayload;
    private Date mCreatedAt, mExpiry, mUpdatedAt;
    private String mObjectId, mStatus;
    private int mServerUpdateStatus = 0;

    /**
     * Set payload.
     *
     * @param payload FCMNotificationPayload
     */
    public void setNotificationPayload(FCMNotificationPayload payload) {
        this.mPayload = payload;
    }

    /**
     * Set notification's server date of creation.
     *
     * @param createdAt Date
     */
    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    /**
     * Used to set Notification objectId.
     *
     * @param objectId String
     */
    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

    /**
     * Used to set notification status as "acted".
     *
     * @param status "acted"
     */
    public void setStatus(String status) {
        mStatus = status;
    }

    /**
     * Flag to check if notification status is updated to server.
     *
     * @param serverUpdateStatus 0 by default; 1 to notify that it is updated to server.
     */
    public void setServerUpdateStatus(int serverUpdateStatus) {
        mServerUpdateStatus = serverUpdateStatus;
    }

    /**
     * Set Expiry date if any.
     *
     * @param expiry Date
     */
    public void setExpiry(Date expiry) {
        mExpiry = expiry;
    }

    /**
     * Get payload.
     *
     * @return FCMNotificationPayload
     */
    public FCMNotificationPayload getNotificationPayload() {
        return mPayload;
    }

    /**
     * Get notification's server date of creation.
     *
     * @return Date
     */
    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    /**
     * Get notification objectId.
     *
     * @return String
     */
    public String getObjectId() {
        return mObjectId;
    }

    /**
     * Get notification Status.
     *
     * @return String; "acted" or "received".
     */
    public String getStatus() {
        return mStatus;
    }

    /**
     * Get expiry date.
     *
     * @return Date
     */
    public Date getExpiry() {
        return mExpiry;
    }

    /**
     * Notify if notification status is "acted".
     *
     * @return true if notification status is "acted" else false.
     */
    public boolean isActed() {
        if (mStatus != null)
            if (mStatus.equals(Constants.acted))
                return true;
        return false;
    }

    /**
     * Notify if notification status is updated to server.
     *
     * @return true if updated else false.
     */
    public boolean isUpdatedToServer() {
        if (mServerUpdateStatus == 1)
            return true;
        return false;
    }

    /**
     * Notify if current date is after specified expiry date.
     *
     * @return true if current date is after expiry date else false.
     */
    public boolean isExpired() {
        if (mExpiry != null) {
            return !mExpiry.after(new Date());
        }
        return false;
    }
}
