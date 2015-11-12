package checkpoint.andela.parser;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Oluwatosin on 11/10/2015.
 */
public class FileParserTest extends TestCase {
        FileParser fp;
        Record record;
        KeyValue kv = new KeyValue();
        ArrayList<Record> testList;

    @Override
    public void setUp() throws Exception {
        fp = new FileParser("fileparsertest.txt");
        record = new Record();
        record = fp.parseFile();
        testList = new ArrayList<>();
    }

    public void testParse() throws Exception {
        testList = fp.parse(record);
        for (Record record: testList){
            System.out.println(record.getKeys());
        }
        assertEquals(1, testList.size());
    }

    public void testParseFile() throws Exception {
       kv =  record.getKeyValue();
        assertEquals(kv.getKey(), "UNIQUE-ID");
        assertEquals(kv.getValue(), "3.4.16.4-RXN" );
    }
}