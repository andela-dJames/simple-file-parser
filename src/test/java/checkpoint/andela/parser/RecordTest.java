package checkpoint.andela.parser;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * A Test for Record class.
 */
public class RecordTest extends TestCase {
    KeyValue kv = new KeyValue("UNIQUE-ID", "PPGPPSYN-RXN");
    Record record = new Record();

    @Override
    public void setUp() throws Exception {
        KeyValue kv2 = new KeyValue("TYPES", "Small-Molecule-Reactions");
        KeyValue kv3 = new KeyValue("TYPES", "Small-Molecule-Reactions");
        KeyValue kv4 = new KeyValue("TYPES", "Small-Molecule-Reactions");
        KeyValue kv5 = new KeyValue("TYPES", "Small-Molecule-Reactions");
        KeyValue kv6 = new KeyValue("TYPE", "Small-Molecule-Reactions");

        record.addNewKeyValue(kv, kv2, kv3, kv4, kv5, kv6);
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
        assertEquals(6, record.size());
    }
    @Test
    public void testUniqueID() {
        String id = record.uniqueID();
        assertEquals(id, "UNIQUE-ID: PPGPPSYN-RXN" );

    }

}