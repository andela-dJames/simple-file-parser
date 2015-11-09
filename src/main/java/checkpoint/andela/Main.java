package checkpoint.andela;

import checkpoint.andela.parser.*;

import java.io.*;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Record rec = new Record();
        String file = "reactions.dat";
        FileParser fp = new FileParser(file);
        Record record = fp.parseFile();
        int count = 0;
        //System.out.print(!record.isEmpty());
        while (!record.isEmpty()){
            KeyValue kv = record.getKeyValue();
            //rec.addnewKeyValue(kv);
            //if(kv.getKey().startsWith("UNIQUE-ID")){
                System.out.println(rec.getKeys());
                rec.clear();
                count++;

           // }
            rec.addnewKeyValue(kv);



        }
        System.out.println(count);


//       TempBuffer logBuffer = new TempBuffer();
//        KeyValue value = new KeyValue();
//        KeyValue value1 = new KeyValue();
//        KeyValue value2 = new KeyValue();
//        KeyValue value3 = new KeyValue();
//        value.setKey("LEFT");
//        value.setValue("XNRTT");
//        Record record = new Record();
//        record.addnewKeyValue(value);
//        record.addnewKeyValue(value2);
//        record.addnewKeyValue(value3);
//        record.addnewKeyValue(value);
//
//        while (!record.isEmpty()){
//           KeyValue val =  record.getKeyValue();
//            System.out.println(val.getKey()+ val.getValue());
//            System.out.println("done");
//        }
//
//        DBWriter dbWriter = new DBWriter();
//        java.sql.Statement smt = null;
//                try {
//           Connection connection =  dbWriter.connectToDB(DBConstants.DBMS, DBConstants.SERVER_NAME, DBConstants.PORT_NUMBER, DBConstants.DB_NAME, DBConstants.USER_NAME, DBConstants.PASSWORD);
//            System.out.println(connection.isValid(2));
//            smt = connection.createStatement();
//                    smt.executeUpdate(dbWriter.insert(value, DBConstants.TABLE_NAME));
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        dbWriter.insert(value, DBConstants.TABLE_NAME);

//        try {
//            logBuffer.insert(value);
//            logBuffer.Remove();
//            System.out.println(logBuffer.contains(value));
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        String[] arr = null;
//        String file ="reactions.dat";
//        FileParser fp = new FileParser(file);
//        try {
//              logBuffer.insert(fp.parseFile());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(logBuffer.capacity());
//        try {
//            Record record = (Record)logBuffer.Remove();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
