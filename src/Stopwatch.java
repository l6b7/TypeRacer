import java.util.Scanner;

public class Stopwatch implements IStopwatch {
    private long startTimestamp;

    public Stopwatch(){
        setTimeStamp();
    }


    public void setTimeStamp(){
        startTimestamp = System.currentTimeMillis();
    }


    public double getElapsedTime(){
        long elapsedTimeInMillis = System.currentTimeMillis() - startTimestamp;

        return elapsedTimeInMillis/1000.0;
    }
}
