package com.example.kimjeongyong.ozirapfitness;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by KimJeongYong on 2016-05-17.
 */
public class MySharedPreferences
{
    private Context mContext;

    public MySharedPreferences (Context context)
    {
        mContext = context;
    }

    // 값 불러오기
    public String getPreferences(String date){
        SharedPreferences pref = mContext.getSharedPreferences("reservationPreferences",0);
        return pref.getString(date, "");
    }

    // 값 저장하기
    public void savePreferences(String date, String info){
        SharedPreferences pref = mContext.getSharedPreferences("reservationPreferences",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(date, info);
        editor.commit();
    }

    public Map<String,?> getAll(){
        SharedPreferences pref = mContext.getSharedPreferences("reservationPreferences",0);
        return pref.getAll();
    }

    // 값(Key Data) 삭제하기
    public void removePreferences(String date){
        SharedPreferences pref = mContext.getSharedPreferences("reservationPreferences",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(date);
        editor.commit();
    }

    // 값(ALL Data) 삭제하기
    public void removeAllPreferences(){
        SharedPreferences pref = mContext.getSharedPreferences("pref",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
