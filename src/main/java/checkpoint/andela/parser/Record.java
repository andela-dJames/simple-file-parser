package checkpoint.andela.parser;

import java.util.ArrayList;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Record {
    private ArrayList<KeyValue> record;

    public Record() {
        record = new ArrayList<KeyValue>();
    }

    public void addnewKeyValue(KeyValue kv) {
        record.add(kv);
    }

    public void getKeyValue() {
        for (KeyValue kv: record){
            System.out.println(kv.getKey() + " " + kv.getValue());
        }
    }


}
