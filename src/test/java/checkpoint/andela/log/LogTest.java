package checkpoint.andela.log;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Tests for the log Class
 */
public class LogTest extends TestCase {
    String file = "logtest.txt";
    String message = "A log writer test";
    String Activity = "LogTest";
    Log log;
    BufferedReader reader;

    public void setUp() throws Exception {
        super.setUp();
        log = new Log( message );
        reader = new BufferedReader(new FileReader(file));


    }


    public void testwrite() throws Exception {
        Log.write(file, message);
        String line = reader.readLine();
        assertEquals( line, "A log writer test--2015-11-12 16:07--A log writer test");

    }
}