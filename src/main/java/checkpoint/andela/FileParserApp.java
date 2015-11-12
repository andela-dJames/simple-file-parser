package checkpoint.andela;

import checkpoint.andela.db.DBConstants;
import checkpoint.andela.db.DBWriter;
import checkpoint.andela.log.Log;
import checkpoint.andela.parser.FileParser;
import checkpoint.andela.parser.Record;
import checkpoint.andela.temp.TempBuffer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * A file parser app class
 */
public class FileParserApp {
    /**
     * the name or path of file to be read
     */
    private static String fileName;
    /**
     * A buffer to storing the parsed file
     */
    private static TempBuffer<Record> fileBuffer;
    /**
     * A buffer for storing logs
     */
    private static TempBuffer<String> logBuffer;
    /**
     * A record of data
     */
    private static Record record;
    /**
     * A log writer
     */
    private Log logWriter;

    private static boolean reading;
    private boolean writing;
    /**
     * An arraylist of records
     */
    private static ArrayList<Record> records;
    /**
     * A file for writing the log to
     */
    private static String logfile;

    /**
     * creates a new file parser
     */
    public FileParserApp() {

        fileName = "reactions.dat";
        record = new Record();
        logWriter = new Log("File Parser" );
        fileBuffer = new TempBuffer(1224);
        logBuffer = new TempBuffer<>(1224);
        records = new ArrayList<Record>();
        logfile = "log.txt";
        reading = true;
        writing = true;
    }
    /**
     * parses a given file and stores them in a buffer
     * it also writes a log to a buffer
     * @throws IOException
     * @throws InterruptedException
     */
    public  void producer() throws IOException, InterruptedException {
        setReading(true);
        FileParser fileParser = new FileParser(fileName);
        record = fileParser.parseFile();
        records = fileParser.parse(record);
        while(!records.isEmpty()){
        for (Record record: records) {
            fileBuffer.insert(record);
            Log log = new Log("fileParser");
            String messageToLog = "wrote " + record.uniqueID() + " to Buffer";
            logBuffer.insert(log.write(messageToLog));
        }
            records.clear();

        }
        setReading(false);
    }

    /**
     * writes the log from the buffer to a file.
     * @throws InterruptedException
     * @throws IOException
     */
    public void logwriter() throws InterruptedException, IOException {

        while (reading || writing || !logBuffer.isEmpty()) {

            String log = logBuffer.Remove();
            Log.write(logfile, log);

        }

    }

    /**
     * writes the record from the buffer to a database
     * @throws SQLException
     * @throws InterruptedException
     */
    public static void consumer() throws SQLException, InterruptedException {
        Record record = new Record();

        String dbms = DBConstants.DBMS;
        String serverName = DBConstants.SERVER_NAME;
        String portno = DBConstants.PORT_NUMBER;
        String db = DBConstants.DB_NAME;
        String tableName = DBConstants.TABLE_NAME;
        String username = DBConstants.USER_NAME;
        String password = DBConstants.PASSWORD;

         Statement stmt = null;
        Connection con = null;

        DBWriter dbWriter = new DBWriter();
        con = dbWriter.connectToDB(dbms, serverName, portno, db, username, password);
        stmt = con.createStatement();

       while (reading || !fileBuffer.isEmpty()) {

            record = fileBuffer.Remove();

            stmt.executeUpdate(dbWriter.insertquery(record, tableName));

            Log log = new Log("DBwriter");

            String messageToLog = "collected" + record.uniqueID() + " from Buffer";

           logBuffer.insert(log.write(messageToLog));
        }

    }

    public synchronized boolean reading() {
        return reading;
    }

    public synchronized boolean writing() {
        return writing;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public void setWriting(boolean writing) {
        this.writing = writing;
    }
}
