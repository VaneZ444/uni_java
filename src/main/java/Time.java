public class Time {
    private int time;
    public Time(int hours, int minutes, int seconds){
        this(hours*3600+minutes*60+seconds);
    }
    public Time(int time){
        setTime(time);
    }
    public void setTime(int time){
        this.time = time%(24*3600);
    }
    public int getInt(){
        return time;
    }
    public int whatHour(){
        return getInt()/3600;
    }
    public int whatMinute(){
        return (getInt()-whatHour()*3600)/60;
    }
    public int whatSecond(){
        return getInt()-whatHour()*3600-whatMinute()*60;
    }
    public String toString(){
        return whatHour()+" : "+whatMinute()+" : "+whatSecond();
    }
}
