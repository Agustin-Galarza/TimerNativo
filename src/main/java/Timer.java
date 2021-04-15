import java.time.Instant;
import java.time.Duration;
import java.time.Period;

public class Timer {
    private final Instant start;
    private Duration delta;

    public Timer(Instant start){
        this.start = start;
    }

    public Timer(long start){
        this(Instant.ofEpochMilli(start));
    }

    public Timer(){
        this(Instant.now());
    }

    public void stop(Instant end){
        delta = Duration.between(start, end);
        if(delta.isNegative()){
            throw new RuntimeException("Bad end");
        }
    }

    public void stop(){
        this.stop(Instant.now());
    }

    public void stop(long end){
        this.stop(Instant.ofEpochMilli(end));
    }

    public long getResult(){
        return delta.toMillis();
    }

    public int getDays(){
        return (int) delta.toDays();
    }

    public int getHours(){
        return (int) delta.toHours()%24;
    }

    public int getMinutes(){
        return (int) delta.toMinutes()%60;
    }

    public double getSeconds(){
        return delta.getSeconds()%60 + (delta.toMillis()%1000) / 1000d;
    }
    @Override
    public String toString(){
        return String.format("(%d ms) %d dias %d horas %d minutos %d,%03d segundos",
                delta.toMillis(),
                delta.toDays(),
                delta.toHours()%24,
                delta.toMinutes()%60,
                delta.getSeconds()%60,
                delta.toMillis()%1000); //esto es bastante molesto la verdad, joda time es mucho mejor
    }
}
