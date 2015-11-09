package checkpoint.andela.parser;

/**
 * Represents a Key-value pair
 */
public class KeyValue {
    /**
     * A key
     */
    private String key;
    /**
     * A value of the key
     */
    private String value;

    /**
     * creates a new keyValue
     */
    public KeyValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
