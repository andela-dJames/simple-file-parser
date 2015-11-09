package checkpoint.andela.parser;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Oluwatosin on 11/6/2015.
 */
public class RecordTest extends TestCase {
    KeyValue kv = new KeyValue();
    Record record = new Record();

    @Override
    public void setUp() throws Exception {
        record.addnewKeyValue(kv);
    }
    @Test
    public void testAddnewKeyValue() throws Exception {
        assertTrue(record.contain(kv));
    }
    @Test
    public void testGetKeyValue() throws Exception {

    }
    @Test
    public void testSize() throws Exception {
        assertEquals(1, record.size());
    }
}