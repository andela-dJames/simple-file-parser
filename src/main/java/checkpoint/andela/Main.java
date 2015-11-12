package checkpoint.andela;

import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Runs the file parser Application using multithread.
 */
public class Main {
    public static void main(String[] args) {
        FileParserApp fileParserApp = new FileParserApp();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                    fileParserApp.consumer();
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        ExecutorService service1 = Executors.newFixedThreadPool(1);
        service.submit(new Runnable() {
            @Override
            public void run() {

                try {

                   fileParserApp.logwriter();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ExecutorService service3 = Executors.newFixedThreadPool(1);
        service.submit(new Runnable() {
            @Override
            public void run() {

                try {
                    fileParserApp.producer();
                }
                 catch (InterruptedException e) {
                    e.printStackTrace();
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        service.shutdown();
        service1.shutdown();
        service3.shutdown();
    }
}
