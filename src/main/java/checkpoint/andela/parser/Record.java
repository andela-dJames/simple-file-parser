package checkpoint.andela.parser;

import java.util.ArrayList;

/**
 * A class for holding a set of data
 */
public class Record {
    /**
     * A list of key-value objects
     */
    private ArrayList<KeyValue> record;

    /**
     * cretaes a new record
     */
    public Record() {
        record = new ArrayList<KeyValue>();
    }

    /**
     * adds a new object to a record
     * @param kv the object to be added
     */
    public void addnewKeyValue(KeyValue kv) {
        record.add(kv);
    }

    /**
     * Adds a set of similar object to a record
     * @param kv object to be added
     */
    public void addnewKeyValue(KeyValue... kv) {
        for (KeyValue k : kv){
            record.add(k);
        }

    }

    /**
     * @returns all the objects in a record
     */
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

    /**
     *
     * @return the size of a record.
     */
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

    /**
     *
     * @return all the keys in a record in the form of a string
     */
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
    /**
     *
     * @return all the values in a record in the form of a string
     */
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

    /**
     * @return the fields and ignores repeated field names.
     */
    private ArrayList<KeyValue> fields () {

        ArrayList<KeyValue> fields = new ArrayList<>();
        for (KeyValue kv: record){
            if (!found(fields, kv.getKey())){
                fields.add(kv);
            }
        }
        return fields;
    }

    /**
     * @return true if a key is reapeated
     */
    private boolean found(ArrayList<KeyValue> kv, String identical) {
        for (KeyValue k: kv){
            if (k.getKey().equals(identical)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the key and value of the unique item.
     */
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