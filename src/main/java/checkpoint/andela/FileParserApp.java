package checkpoint.andela;

import checkpoint.andela.db.DBConstants;
import checkpoint.andela.db.DBWriter;
import checkpoint.andela.parser.FileParser;
import checkpoint.andela.parser.KeyValue;
import checkpoint.andela.parser.Record;
import checkpoint.andela.temp.TempBuffer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Oluwatosin on 11/7/2015.
 */
public class FileParserApp {
    private String fileName;
    private TempBuffer fileBuffer;
    private Record record;
    private Record bufferRecord;

    public void executeThreads() {
        ExecutorService producer = Executors.newFixedThreadPool(1);
        producer.execute(new Runnable() {
            @Override
            public void run() {
                readFileToBuffer();
            }
        });
        ExecutorService bufferexec = Executors.newFixedThreadPool(1);
        producer.execute(new Runnable() {
            @Override
            public void run() {
                readFileToBuffer();
            }
        });
        ExecutorService consumer = Executors.newFixedThreadPool(1);
        producer.execute(new Runnable() {
            @Override
            public void run() {
                readFileToBuffer();
            }
        });

    }
    public void readFileToBuffer() {
        FileParser fileParser = new FileParser(fileName);
        try {
            record = fileParser.parseFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromBuffer() {


    }

    public void writeToBuffer(){
        Record rec = new Record();
        while (!record.isEmpty()) {
            KeyValue kv = record.getKeyValue();
            //rec.addnewKeyValue(kv);
            if (kv.getKey().startsWith("UNIQUE-ID")) {
                try {
                    if (fileBuffer.isEmpt())
                    fileBuffer.insert(rec);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rec.clear();
            }
            rec.addnewKeyValue(kv);
        }
    }

    public void writeToDB() {
        String dbms = DBConstants.DBMS;
        String serverName = DBConstants.SERVER_NAME;
        String portno = DBConstants.PORT_NUMBER;
        String db = DBConstants.DB_NAME;
        String tableName = DBConstants.TABLE_NAME;
        String username = DBConstants.USER_NAME;
        String password = DBConstants.PASSWORD;
        DBWriter dbWriter = new DBWriter();
        Statement stmt = null;
        Connection con = null;
        try {
            con = dbWriter.connectToDB(dbms, serverName,portno, db, username, password);
            stmt = con.createStatement();
            stmt.executeUpdate(dbWriter.insertquery(bufferRecord, tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
