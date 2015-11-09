package checkpoint.andela.log;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class for logging events
 */
public class Log {
    /**
     * the name of the task
     */
    private String TASK;
    /**
     * the time of execution
     */
    private DateTime dateTime;
    /**
     * the message to log
     */
    private String message;
    /**
     * A bufferedwriter
     */
    private BufferedWriter bufferedWriter;

    /**
     * Creates a new log with the given parameters
     * @param taskName the name of the task
     * @param dateTime the time of the execution
     * @param message the message to log
     */
    public Log(String taskName, DateTime dateTime, String message) {
        TASK = taskName;
        this.dateTime = dateTime;
        this.message = message;
    }

    public Log(String file, String taskName, String message) throws IOException {
        this(taskName, DateTime.now(), message);
         bufferedWriter = new BufferedWriter(new FileWriter(file));
    }

    /**
     * Builds the log
     * @return the content of the log
     */
    public String log() {
        return TASK + " " + message + " " + dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * writes the log to a file
     * @throws IOException
     */
    public void write () throws IOException {
        bufferedWriter.write(log());
    }
}
