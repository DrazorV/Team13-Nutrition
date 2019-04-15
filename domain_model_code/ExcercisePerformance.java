import java.util.Date;

public class ExcercisePerformance {
    private Date date;
    private double duration;
    private String  dayperiod;

    public ExcercisePerformance(double duration,String dayperiod){
        this.duration=duration;
        this.dayperiod=dayperiod;
        date=new Date();
    }
    public Date getDate(){
        return date;
    }
    public double getDuration(){
        return duration;
    }
    public String getDayperiod(){
        return dayperiod;
    }
}
