package checkpoint.andela;

import checkpoint.andela.log.Log;
import checkpoint.andela.parser.FileParser;
import checkpoint.andela.parser.KeyValue;
import checkpoint.andela.parser.Record;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser("reactions.dat");
        ArrayList<Record> bufferrecords = new ArrayList<Record>();
        Record record = new Record();
        Record rec = new Record();
        try {

            record = fileParser.parseFile();
            do{
                KeyValue kv = record.getKeyValue();
                //rec.addnewKeyValue(kv);
                if (kv.getKey().startsWith("UNIQUE-ID")) {
                    bufferrecords.add(rec);
                    rec = new Record();

                }
                rec.addnewKeyValue(kv);
                //System.out.println(kv.getKey());
            }while (!record.isEmpty());


            bufferrecords.remove(0);
            for (Record record1: bufferrecords){
                System.out.println(record1.getKeys());
            }
            System.out.println(bufferrecords.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static Record createRecord() {
//        FileParser fileParser = new FileParser("reactions.dat");
//        ArrayList<Record> bufferrecords = new ArrayList<Record>();
//        Record record = new Record();
//        Record rec = new Record();
//        //for ()
//    }
}
