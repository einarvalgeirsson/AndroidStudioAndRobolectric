package com.example.fing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fing.util.DateUtil;


public class StringOnFingerActivity extends Activity implements View.OnClickListener {

    Button mSnooze;
    Button mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stringfinger);
        mSnooze = (Button)findViewById(R.id.snooze);
        mCancel = (Button)findViewById(R.id.cancel);
        mSnooze.setVisibility(View.VISIBLE);
        mCancel.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        Reminder reminder = new Reminder(getApplicationContext());
        if(v == findViewById(R.id.snooze)) {
            reminder.setReminderTo(DateUtil.getDateMinutesFromNow(1));
            exitApplication();
        } else if (v == findViewById(R.id.cancel)) {
            reminder.cancelAlarm(reminder.getPendingIntent());
            exitApplication();
        }
    }

    private void exitApplication() {
        this.finish();
    }
}
