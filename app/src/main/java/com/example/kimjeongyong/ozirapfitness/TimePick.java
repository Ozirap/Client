package com.example.kimjeongyong.ozirapfitness;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.kimjeongyong.fitnesscheck2.R;

/**
 * Created by KimJeongYong on 2016-05-17.
 */
public class TimePick extends AppCompatActivity {

    int hour, minute;
    public TextView timeDisplay;
    TimePicker tp;
    public String FILENAME, content;


    public void setStringName ()
    {
        FILENAME=Calendar.filename;
    }

    @TargetApi(Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState)
    {
        final MySharedPreferences pref = new MySharedPreferences(this.getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepick);
//        Log.i("TimePick",MainActivity.filename+"");
        timeDisplay = (TextView) findViewById(R.id.textView);
        tp = (TimePicker)findViewById(R.id.timePicker);
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int _minute) {
                hour = hourOfDay;
                minute = _minute;
                Log.i("TimePick", "timePicker.onTimeChangedListener: " + hour + ":" + minute);
            }
        });


        //close butt-on
        Button closeButton = (Button)findViewById(R.id.closeb);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimePick.this, Calendar.class);
                startActivity(intent);
            }
        });

        //set the name of the text file
        setStringName();
        Log.i("TimePick", "filename: " + FILENAME);
        char[] monthchar = new char[2];
        char[] daychar = new char[2];
        FILENAME.getChars(4,6,monthchar,0);
        FILENAME.getChars(6,8,daychar,0);
        final String month = new String(monthchar);
        final String day = new String (daychar);

        //save butt-on
        Button saveButton = (Button)findViewById(R.id.saveb);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                content = hour + "시" + " " + minute + "분 저장됨";
                Log.i("TimePick", "content: " + content);
                Log.i("TimePick", month+day);
                pref.savePreferences(FILENAME, content);
                timeDisplay.setText(month + "월" + day + "일" + " " + pref.getPreferences(FILENAME));
            }
//                try {
//                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
//                    fos.write(content.toString().getBytes());
//                    fos.close();
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                  displays the time for saved appointment
//                try
//                {
//                    FileInputStream fis = openFileInput(FILENAME);
//                    byte[] buffer = new byte[fis.available()];
//                    fis.read(buffer);
//                    timeDisplay.setText(new String(buffer));
//                    fis.close();
//            timeDisplay.setText("약속없음");
//
//                }
//                catch (FileNotFoundException e) {}
//                catch (IOException e) {}
//             }
        });
        if(pref.getPreferences(FILENAME).length()!=0)
            timeDisplay.setText(pref.getPreferences(FILENAME));
        else
            timeDisplay.setText(month + "월" + day + "일" + " " + "약속없음");

//        try
//        {
//            FileInputStream fis = openFileInput(FILENAME);
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            if (buffer.length != 0)
//            {
//                Log.i("TimePick", "" + buffer.length);
//                timeDisplay.setText(new String(buffer));
//            fis.close();}
//            else
//            timeDisplay.setText("약속없음");
//        }
//        catch (FileNotFoundException e) {}
//        catch (IOException e) {}

        Button deleteButton = (Button)findViewById(R.id.deleteb);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeDisplay.setText("삭제됨");
                pref.removePreferences(FILENAME);
            }
        });
    }


}

