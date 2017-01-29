package com.vidyanand.fcmpushlibrary.AppConstants;


public class Constants {

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String FCM_TOKEN = "fcm_token";
    public static final String TOKEN_EXISTS = "token_exists";

    public static final String NOTIFICATION_PAYLOAD_KEY = "com.vidyanand.notification.payload";

    public static final String RECEIVER_FILTER_REG = "com.vidyanand.registrationComplete";
    public static final String RECEIVER_FILTER_MSG = "com.vidyanand.messageReceived";

    // Notification Status Values
    public static final String received             =   "received";
    public static final String acted                =   "acted";

    // Push Notifications
    public static final class PushNotification {
        public static final String payload		=	"com.parse.Data";
        public static final String channel		=	"com.parse.Channel";
        public static final String alert		=	"alert";
        public static final String dialog		=	"d";
        public static final String type 		=	"t";
        public static final String objectId     =   "o";

        // actions
        public static final String action				=	"a";
        public static final String actionOpenPage		=	"p";
        public static final String actionFetchZippr		=	"fz";
        public static final String actionOpenZippr		=	"oz";

        // type values
        public static final int typePremiumZippr        =    1;
        public static final int typeRequestZippr        =    2;


        public static final String fcmTitle = "title";
        public static final String fcmMessage = "message";
        public static final String fcmImageUrl = "img_url";
        public static final String fcmNotifType = "type";
        public static final String fcmCallToActionObj = "cta";
        public static final String fcmCallToActionAction = "action";
        public static final String fcmCallToActiondata = "data";
    }
}
