# FCM-Push-Notification-Library

Firebase Cloud Messaging example using FCMPushLibrary.

#Step 1:
Create new android studio project and add it to the firebase console

How to add project to firebase console?

You can use "Firebase Asistant" for Android Studio 2.2 or above.
Click on Tools > Firebase

Manually:-
- Login to the https://console.firebase.google.com
- Click on "Create new project" and fill the required details
- Follow the instructions

#Step 2:
Add "FCMPushLibrary" as a module to your project and edit your app .gradle file

dependencies {
    ...
    compile project(':fcmpushlibrary')
}

#Step 3:
To listen the refreshed token or messges you are receiving

- Create on class and extend with FcmEventReceiver
- Override the onReceive() and you will receive everything in your app.

That's it. Please find the "FCMSample" app for the reference and "FcmPushLibrary" as module.


#How to test FCM push notification?

Way 1: Using Firebase Console
- Go to the firebase console and click on your project
- Find an option "Notifications" to the left side menu list > click and start sending.


Way 2: Using Rest Client or Postman or any other you know

- URL: https://fcm.googleapis.com/fcm/send
- Method: POST
- Headers: Content-Type:application/json and Authorization:<Your Server Key>

Find Server Key from firebase console, goto project > left above corner setting icon > click Project Setting 
> Cloud Messaging tab > Server Key

- Add request body payload
{"data": {"title": "Beamer","text": "Test Message",},"registration_ids":["<Your Device Registration Token>"]} 

Find Device registration token in your onReceive listener.


#Thank you! Any comments are welcome.



