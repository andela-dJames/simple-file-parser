package checkpoint.andela.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Deserializer {
    private String file;

    public KeyValue deserialize(KeyValue kv) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);

        kv = (KeyValue) objectInputStream.readObject();

        return kv;
    }

}
