package checkpoint.andela.log;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.*;

/**
 * A class for logging events
 */
public class Log {
    /**
     * the name of the task
     */
    private static String TASK;
    /**
     * the time of execution
     */
    private static String dateTime;
    /**
     * the message to log
     */
    private String message;
    /**
     * A bufferedwriter
     */
    private BufferedWriter bufferedWriter = null;

    public Log() {
    }

    /**
     * Creates a new log with the given parameter
     * @param taskName the name of the task
     */
    public Log(String taskName) {
        TASK = taskName;
    }
    /**
     * Builds the log
     * @return the content of the log
     */
    private static String log(String message) {
        dateTime = DateTime.now().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"));
       return TASK + "--"+ dateTime + "--" +message;
    }

    public String write( String message) {
      return log(message);
    }
    /**
     * writes the log to a file with the given parameters
     *  @param fileName the name of the file to be written to
     * @param mesg the message to log
     * @throws IOException
     */
    public static void write (String fileName, String mesg) throws IOException {
        mesg = log(mesg);
        BufferedWriter bw = null;
        try {


            FileWriter fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(mesg);


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){

            }
        }
    }
}


