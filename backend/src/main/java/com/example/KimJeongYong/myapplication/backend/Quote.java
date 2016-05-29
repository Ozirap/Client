package com.example.KimJeongYong.myapplication.backend;

/**
 * Created by KimJeongYong on 2016-04-07.
 */
public class Quote {
    Long id;
    String who;
    String whom;
    public Long getID(){
        return id;
    }

    public void SedId(Long id){
        this.id = id;
    }

    public String getWho(){
        return who;
    }

    public void setWho(String who){
        this.who=who;
    }

    public String getWhom(){
        return whom;
    }

    public void setWhom(String Whom){
        this.whom = whom;
    }
}
