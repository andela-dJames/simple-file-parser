package checkpoint.andela;

import checkpoint.andela.parser.FileParser;
import checkpoint.andela.parser.KeyValue;
import checkpoint.andela.parser.Record;
import checkpoint.andela.temp.TempBuffer;

import java.io.IOException;

/**
 * Created by Oluwatosin on 11/7/2015.
 */
public class FileParserApp {
    private String fileName;
    private TempBuffer fileBuffer;
    private Record record;
    public void readFileToBuffer() {
        FileParser fileParser = new FileParser(fileName);
        try {
            record = fileParser.parseFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        
    }

}
