package checkpoint.andela.log;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by Oluwatosin on 11/6/2015.
 */
public class Log {

    private String TASK;

    private DateTime dateTime;

    private String message;

    public Log(String taskName, DateTime dateTime, String message) {
        TASK = taskName;
        this.dateTime = dateTime;
        this.message = message;
    }

    public Log(String taskName, String message) {
        this(taskName, DateTime.now(), message);
    }

    public void log() {
        System.out.println(TASK + " " + message + " " + dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
