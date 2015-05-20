package com.example.fing;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.fing.util.DateUtil;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button mStringButton;
    CheckBox mOneHour;
    CheckBox mAfternoon;
    CheckBox mEvening;
    CheckBox mTomorrow;

    Reminder mReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReminder = new Reminder(getApplicationContext());
        setupViews();
    }

    private void setupViews() {
        mStringButton = (Button) findViewById(R.id.remind_button);

        mOneHour = (CheckBox) findViewById(R.id.remind_hour);
        mAfternoon = (CheckBox) findViewById(R.id.afternoon_reminder);
        mEvening = (CheckBox) findViewById(R.id.evening_reminder);
        mTomorrow = (CheckBox) findViewById(R.id.tomorrow_reminder);

        mOneHour.setVisibility(View.INVISIBLE);
        mAfternoon.setVisibility(View.INVISIBLE);
        mEvening.setVisibility(View.INVISIBLE);
        mTomorrow.setVisibility(View.INVISIBLE);

        mStringButton.setOnClickListener(this);
        mOneHour.setOnClickListener(this);
        mAfternoon.setOnClickListener(this);
        mEvening.setOnClickListener(this);
        mTomorrow.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == mStringButton) {
            showReminderOptions();
        } else if ( v == mOneHour) {
            mReminder.setReminderTo(DateUtil.getDateMinutesFromNow(1));
            exitApplication();
        } else if ( v == mAfternoon) {
            mReminder.setReminderTo(DateUtil.getTodayAtHour(15));
            exitApplication();
        } else if (v == mTomorrow) {
            mReminder.setReminderTo(DateUtil.getDateDaysFromToday(1));
        }
    }

    private void showReminderOptions() {
        mOneHour.setVisibility(View.VISIBLE);
        mTomorrow.setVisibility(View.VISIBLE);
        mAfternoon.setVisibility(View.VISIBLE);
        mEvening.setVisibility(View.VISIBLE);
    }

    private void exitApplication() {
        this.finish();
//        System.exit(0);
    }
}
