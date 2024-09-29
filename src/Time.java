public class Time {
    int time;
    public String tellTime(){
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
