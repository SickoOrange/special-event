package com.berber.orange.memories;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.berber.orange.memories.model.db.NotificationSending;
import com.berber.orange.memories.model.db.NotificationSendingDao;

import java.util.Date;
import java.util.List;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == NotificationService.INTENT_ALARM_LOG) {
            Log.e("AlarmReceiver", "启动扫描服务");
            startScanTask(context);
            Intent i = new Intent(context, NotificationService.class);
            context.startService(i);
        }

    }

    private void startScanTask(Context context) {
        APP mApplication = ((APP) context.getApplicationContext());
        NotificationSendingDao notificationSendingDao = mApplication.getDaoSession().getNotificationSendingDao();
        List<NotificationSending> list = notificationSendingDao.queryBuilder().where(NotificationSendingDao.Properties.SentDate.isNotNull()).list();
        for (NotificationSending notificationSending : list) {
            sendingNotification(notificationSending);
            notificationSending.setSentDate(new Date());
        }

        notificationSendingDao.updateInTx(list);

    }

    private void sendingNotification(NotificationSending notificationSending) {

    }
}
