package com.example.android.notificationchannels;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class NotifActivity extends Activity {
    Button mostrarNotificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif); mostrarNotificacion=(Button)findViewById(R.id.btnMostrarNotificacion);

        mostrarNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Notification.Builder mBuilder;
                NotificationManager mNotifyMgr =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


                int icono = R.mipmap.ic_launcher;
                Intent i=new Intent(NotifActivity.this, MensajeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotifActivity.this, 0, i, 0);

                mBuilder = new Notification.Builder(getApplicationContext(), "default")
                        .setContentTitle("Titulo")
                        .setContentText("Hola que tal")
                        .setSmallIcon(getSmallIcon())
                        .setAutoCancel(true);

                NotificationChannel chan1 = new NotificationChannel("default",
                        getString(R.string.noti_channel_default), NotificationManager.IMPORTANCE_DEFAULT);
                chan1.setLightColor(Color.GREEN);
                chan1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
                mNotifyMgr.createNotificationChannel(chan1);
                mNotifyMgr.notify(1, mBuilder.build());

                //mNotifyMgr.notify(1, mBuilder.build());

            }
        });
    }





    /**
     * Get the small icon for this app
     *
     * @return The small icon resource id
     */
    private int getSmallIcon() {
        return android.R.drawable.stat_notify_chat;
    }

}
