package checkpoint.andela;

import checkpoint.andela.parser.KeyValue;

import java.io.*;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        KeyValue kv = new KeyValue();
        KeyValue kvnew = null;
        kv.setKey("Daniel");
        kv.setValue("James");
        System.out.println(kv.getKey()+kv.getValue());
        try {
            FileOutputStream f = new FileOutputStream("Serialized.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(kv);
            f.close();
            o.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream("Serialized.ser");
            ObjectInputStream oj = new ObjectInputStream(in);
            kvnew = (KeyValue) oj.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(kvnew.getKey() +kvnew.getValue());

    }
}
