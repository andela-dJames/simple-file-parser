package checkpoint.andela.db;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Test for DBWRITER Class
 */
public class DBWriterTest extends TestCase {
    String dbms = DBConstants.DBMS;
    String serverName = DBConstants.SERVER_NAME;
    String portno = DBConstants.PORT_NUMBER;
    String db = DBConstants.DB_NAME;
    String tableName = DBConstants.TABLE_NAME;
    String username = System.getenv(DBConstants.USER_NAME);
    String password = System.getenv(DBConstants.PASSWORD);

    Statement stmt = null;
    Connection con;

    @Override
    public void setUp() throws Exception {

    }



    public void testConnectToDB() throws Exception {

        DBWriter dbWriter = new DBWriter();

        Class.forName(DBConstants.MYSQL_DRIVER);

        con = dbWriter.connectToDB(dbms, serverName, portno, db, username, password);

       assertTrue(con.isValid(5));


    }

    public void testBuildPropperties() throws Exception {


    }

    public void testInsertquery() throws Exception {

    }
}