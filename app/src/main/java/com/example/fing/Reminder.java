package com.example.fing;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class Reminder {

    private static final String TAG = Reminder.class.getCanonicalName();

    AlarmManager mAlarmManager;
    Context mContext;
    PendingIntent mIntent;

    public Reminder(Context context) {
        mContext = context;
        mAlarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        mIntent = PendingIntent.getActivity(mContext, 0, new Intent(mContext, StringOnFingerActivity.class).setAction(Intent.ACTION_VIEW), PendingIntent.FLAG_ONE_SHOT);

    }

    public void setReminderTo(Date timeToRemind) {
        mAlarmManager.set(AlarmManager.RTC_WAKEUP, timeToRemind.getTime(), mIntent);
        Log.d(TAG, "Alarm set to " + timeToRemind.toString());
    }

    public void cancelAlarm(PendingIntent mIntent) {
        mAlarmManager.cancel(mIntent);
    }

    public PendingIntent getPendingIntent() {
        return mIntent;
    }
}
