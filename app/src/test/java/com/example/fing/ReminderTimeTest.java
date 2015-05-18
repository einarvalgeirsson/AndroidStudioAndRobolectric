package com.example.fing;

import android.app.AlarmManager;
import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowAlarmManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(CustomRobolectricRunner.class)
public class ReminderTimeTest {

    Context mContext;
    com.example.fing.MainActivity mMain;
    ShadowAlarmManager mShadowAlarmManager;

    @Before
    public void setUp() {
        mMain = Robolectric.buildActivity(com.example.fing.MainActivity.class).create().get();
        mContext = RuntimeEnvironment.application.getApplicationContext();
        mShadowAlarmManager = Shadows.shadowOf((AlarmManager) RuntimeEnvironment.application.getSystemService(Context.ALARM_SERVICE));
    }

    @After
    public void tearDown() {
        mMain = null;
    }

    @Test
    public void if_afternoon_checkbox_is_ticked_the_reminder_is_set_for_the_coming_afternoon() {
        Button mReminderButton = (Button) mMain.findViewById(R.id.remind_button);
        CheckBox afternoonCheckbox = (CheckBox) mMain.findViewById(R.id.afternoon_reminder);

        mReminderButton.callOnClick();

        afternoonCheckbox.callOnClick();
        ShadowAlarmManager.ScheduledAlarm scheduledAlarm = mShadowAlarmManager.peekNextScheduledAlarm();

        assertThat(scheduledAlarm).isNotNull();
    }
}