package checkpoint.andela;

import checkpoint.andela.parser.*;
import checkpoint.andela.temp.TempBuffer;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by Oluwatosin on 11/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        TempBuffer logBuffer = new TempBuffer();
        KeyValue value = new KeyValue();
        try {
            logBuffer.insert(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(logBuffer.capacity());


    }
}
