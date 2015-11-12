package checkpoint.andela.parser;

import java.util.ArrayList;

/**
 *
 */
public class Record {
    private ArrayList<KeyValue> record;

    public Record() {
        record = new ArrayList<KeyValue>();
    }

    public void addnewKeyValue(KeyValue kv) {
        record.add(kv);
    }
    public void addnewKeyValue(KeyValue... kv) {
        for (KeyValue k : kv){
            record.add(k);
        }

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
        for (KeyValue kv : fields()){
            keys.append("`")
                    .append(kv.getKey())
                    .append("`,");
        }
        keys.deleteCharAt(keys.length() - 1);
        return keys.toString();
    }

    public String getValues() {
        StringBuilder values = new StringBuilder();
        for (KeyValue kv : fields()){
            if (kv.getValue().contains("\'")){
            }
            values.append("'\\")
                    .append(kv.getValue())
                    .append("',");
        }
        values.deleteCharAt(values.length() - 1);
        return values.toString();
    }
    public ArrayList<KeyValue> fields () {

        ArrayList<KeyValue> fields = new ArrayList<>();
        for (KeyValue kv: record){
            if (!found(fields, kv.getKey())){
                fields.add(kv);
            }
        }
        return fields;
    }

    public ArrayList<KeyValue> rows(){
        ArrayList<KeyValue> rows = new ArrayList<>();

        for (KeyValue kv : record){
            if (!found(rows, kv.getKey())){

                rows.add(kv);
            }
        }
        return rows;
    }

    public boolean found(ArrayList<KeyValue> kv, String identical) {
        for (KeyValue k: kv){
            if (k.getKey().equals(identical)){
                return true;
            }
        }
        return false;
    }

    public String uniqueID() {
        String id = "";
        for (KeyValue kv: record){
            if (kv.getKey().equals("UNIQUE-ID")){
                id+=kv.getKey() + ": " + kv.getValue();
            }
        }
        return id;
    }
}