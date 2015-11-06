package checkpoint.andela.parser;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Serialiser {
    private String file;

    public Serialiser(String file) {
        this.file = file;
    }

    public void serialize(ArrayList<ArrayList<KeyValue>> kv) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);

        objectInputStream.writeObject(kv);

        fileOutputStream.close();

        objectInputStream.close();

    }
}
