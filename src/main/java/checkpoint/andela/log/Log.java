package checkpoint.andela.log;

import org.joda.time.DateTime;

import java.io.*;
import java.nio.file.StandardOpenOption;

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
    private BufferedWriter bufferedWriter = null;

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
    public String log(String message) {
        dateTime = DateTime.now();
       return TASK + "--"+ dateTime + "--" +message;
    }

    /**
     * writes the log to a file with the given parameters
     *  @param fileName the name of the file to be written to
     * @param mesg the message to log
     * @throws IOException
     */
    public void write (String fileName, String mesg) throws IOException {
        mesg = log(mesg);
        BufferedWriter bw = null;
        try {


            FileWriter fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println();
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


