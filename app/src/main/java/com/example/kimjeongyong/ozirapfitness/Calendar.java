package com.example.kimjeongyong.ozirapfitness;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.kimjeongyong.fitnesscheck2.R;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by KimJeongYong on 2016-05-17.
 */
public class Calendar extends AppCompatActivity {
    public static String filename;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        final CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(java.util.Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(java.util.Calendar.YEAR));
        caldroidFragment.setArguments(args);


        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendarView, caldroidFragment);
        t.commit();

        final MySharedPreferences pref = new MySharedPreferences(this.getApplicationContext());
        SimpleDateFormat dateFormatColor = new SimpleDateFormat("yyyyMMdd");

        Map<String, ?> allEntries = pref.getAll();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            try {
                Date date = dateFormatColor.parse(entry.getKey().toString());
                ColorDrawable green = new ColorDrawable(Color.GREEN);
                caldroidFragment.setBackgroundDrawableForDate(green, date);
                caldroidFragment.refreshView();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        CaldroidListener listener = new CaldroidListener() {
            @Override
            //put selected dates in the data array
            public void onSelectDate(Date date, View view) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                filename = dateFormat.format(date);
                Intent intent = new Intent(Calendar.this, TimePick.class);
                startActivity(intent);

                return;

            }

        };
        caldroidFragment.setCaldroidListener(listener);
        //invoke once more to reflect changes

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.i("map values", entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}
