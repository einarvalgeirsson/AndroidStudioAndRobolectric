package com.example.fing;


import android.view.View;
import android.widget.Button;

import com.example.fing.util.DateUtil;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(CustomRobolectricRunner.class)
public class ViewTest {

    com.example.fing.MainActivity mMain;

    @After
    public void tearDown() {
        DateUtil.setDateForTest(null);
    }

    @Test
    public void only_the_main_reminder_button_is_seen_when_main_activity_is_started() {
        mMain = Robolectric.buildActivity(com.example.fing.MainActivity.class).create().get();

        // Main button is visible
        assertThat(mMain.findViewById(R.id.remind_button).getVisibility()).isEqualTo(View.VISIBLE);

        // Checkboxes for reminder time are invisible
        assertThat(mMain.findViewById(R.id.remind_hour).getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(mMain.findViewById(R.id.evening_reminder).getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(mMain.findViewById(R.id.tomorrow_reminder).getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(mMain.findViewById(R.id.afternoon_reminder).getVisibility()).isEqualTo(View.INVISIBLE);
    }

    @Test
    public void if_main_reminder_button_is_clicked_in_the_morning_all_the_checkboxes_are_displayed() {
        // It's nine o'clock in the mornin'
        Date morningDate = DateUtil.getTodayAtHour(9);
        DateUtil.setDateForTest(morningDate);

        mMain = Robolectric.buildActivity(com.example.fing.MainActivity.class).create().get();

        // Checkboxes are not visible
        assertThat(mMain.findViewById(R.id.remind_hour).getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(mMain.findViewById(R.id.evening_reminder).getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(mMain.findViewById(R.id.tomorrow_reminder).getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(mMain.findViewById(R.id.afternoon_reminder).getVisibility()).isEqualTo(View.INVISIBLE);

        // Button is clicked
        Button mainReminderButton = (Button) mMain.findViewById(R.id.remind_button);
        mainReminderButton.performClick();

        // All checkboxes are now visible
        assertThat(mMain.findViewById(R.id.remind_hour).getVisibility()).isEqualTo(View.VISIBLE);
        assertThat(mMain.findViewById(R.id.evening_reminder).getVisibility()).isEqualTo(View.VISIBLE);
        assertThat(mMain.findViewById(R.id.tomorrow_reminder).getVisibility()).isEqualTo(View.VISIBLE);
        assertThat(mMain.findViewById(R.id.afternoon_reminder).getVisibility()).isEqualTo(View.VISIBLE);
    }
}