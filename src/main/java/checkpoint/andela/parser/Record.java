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

    public KeyValue getKeyValue() {
        KeyValue keyValue;
        for (KeyValue kv: record){
            record.remove(kv);
          return keyValue = kv;
        }
    return null;
    }

    public ArrayList<KeyValue> getRecord() {
        return record;
    }

    public void setRecord(ArrayList<KeyValue> record) {
        this.record = record;
    }

    public int size() {
        return record.size();
    }

    public boolean contain(KeyValue kv) {
        return record.contains(kv);
    }

    public boolean isEmpty() {
        return record.isEmpty();
    }

    public void clear() {
        record.clear();
    }
    public String getKeys() {
        StringBuilder keys = new StringBuilder();
        for (KeyValue kv : record){
            keys.append("`")
                    .append(kv.getKey())
                    .append("`, ");
        }
        return keys.toString();
    }
    public String getValues() {
        StringBuilder keys = new StringBuilder();
        for (KeyValue kv : record){
            keys.append("'")
                    .append(kv.getValue())
                    .append("', ");
        }
        return keys.toString();
    }
}
