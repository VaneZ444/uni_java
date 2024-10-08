public class Time {
    int time;
    public Time(int hours, int minutes, int seconds){
        this(hours*3600+minutes*60+seconds);
    }
    public Time(int time){
        this.time = time;
    }
    public String toString(){
        int fullSeconds, hours, minutes, seconds;
        fullSeconds = time;
        while (fullSeconds > 86400){
            fullSeconds-=86400;
        }
        hours = fullSeconds/3600;
        minutes = (fullSeconds - hours*3600)/60;
        seconds = (fullSeconds - hours*3600 - minutes*60);
        return hours + " : " + minutes + " : " + seconds;
    }
}
