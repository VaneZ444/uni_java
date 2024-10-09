public class Time {
    int time;
    public Time(int hours, int minutes, int seconds){
        this(hours*3600+minutes*60+seconds);
    }
    public Time(int time){
        this.time = time;
    }
    public int whatHour(){
        return (time%(24*3600))/3600;
    }
    public int whatMinute(){
        return ((time%(24*3600))-whatHour()*3600)/60;
    }
    public int whatSecond(){
        return (time%(24*3600))-whatHour()*3600-whatMinute()*60;
    }
    public String toString(){
        return whatHour()+" : "+whatMinute()+" : "+whatSecond();
    }
}
