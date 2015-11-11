package checkpoint.andela;

import checkpoint.andela.db.DBConstants;
import checkpoint.andela.log.Log;
import checkpoint.andela.parser.FileParser;
import checkpoint.andela.parser.KeyValue;
import checkpoint.andela.parser.Record;
import checkpoint.andela.temp.TempBuffer;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        FileParserApp fileParserApp = new FileParserApp();
        try {
            fileParserApp.producer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
