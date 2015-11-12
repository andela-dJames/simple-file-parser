package checkpoint.andela.temp;

import checkpoint.andela.parser.KeyValue;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test for the Tempbuffer class
 */
public class TempBufferTest extends TestCase {
    KeyValue kv = new KeyValue();
    TempBuffer tempBuffer = new TempBuffer();
    @Override
    public void setUp() throws Exception {
        tempBuffer.insert(kv);
    }

    @Test
    public void testInsert() throws Exception {

        assertTrue(tempBuffer.contains(kv));
    }
    @Test
    public void testRemove() throws Exception {
       Object object = tempBuffer.Remove();
        assertTrue(object==kv);
    }
    @Test
    public void testCapacity() throws Exception {
        assertEquals(tempBuffer.capacity(), 1);
    }
}