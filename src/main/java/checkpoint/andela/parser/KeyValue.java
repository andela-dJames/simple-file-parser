package checkpoint.andela.parser;

import java.io.Serializable;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class KeyValue implements Serializable {
    private String key;
    private String value;

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
