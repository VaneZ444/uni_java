package ru.bryzgalin.misc;

public class Time {
    private final int SECONDS_IN_DAY = 86400;
    private final int SECONDS_IN_HOUR = 3600;
    private final int SECONDS_IN_MINUTE = 60;

    private int time;
    public Time(int hours, int minutes, int seconds){
        this(hours*3600+minutes*60+seconds);
    }
    public Time(int time){
        setTime(time);
    }
    public void setTime(int time){
        this.time = time%SECONDS_IN_DAY;
    }
    public int getInt(){
        return time;
    }
    public int whatHour(){
        return getInt()/SECONDS_IN_HOUR;
    }
    public int whatMinute(){
        return (getInt()-whatHour()*SECONDS_IN_HOUR)/SECONDS_IN_MINUTE;
    }
    public int whatSecond(){
        return getInt()-whatHour()*SECONDS_IN_HOUR-whatMinute()*SECONDS_IN_MINUTE;
    }
    public String toString(){
        return whatHour()+" : "+whatMinute()+" : "+whatSecond();
    }
}
