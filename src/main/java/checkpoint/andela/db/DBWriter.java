package checkpoint.andela.db;

import checkpoint.andela.parser.Record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A Database writer class that contains method for handling database operations
 */
public class DBWriter {
    /**
     * Create a new DBWriter
     */
    public DBWriter() {

    }

    /**
     * establishes connection to a Database with the given parameters
     * @param dbms the database management system
     * @param serverName the name of the server
     * @param portno the connection port
     * @param db the database name
     * @param username the username of the database
     * @param password the password of the user
     * @return
     * @throws SQLException
     */
    public Connection connectToDB(String dbms, String serverName, String portno, String db, String username, String password ) throws SQLException {
        Connection connection = null;

        connection = DriverManager.getConnection("jdbc:"+ dbms + "://" + serverName + ":" + portno + "/" + db, buildPropperties(username, password) );

        return connection;
    }

    /**
     * Build the propertis of the database with the given parameters
     * @param user the username
     * @param password the password of the user
     * @return
     */
    public Properties buildPropperties(String user, String password) {
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", password);
        return properties;
    }

    /**
     * Builds the insert query string
     * @param record the record to be inserted
     * @param table the table to inser into
     * @return the
     */
    private String buildInsertString(Record record, String table) {

        StringBuilder insertString = new StringBuilder();

        insertString.append("Insert into ")
                    .append(table)
                    .append("(")
                    .append(record.getKeys())
                    .append(") Values('")
                    .append(record.getValues())
                    .append("');");

        return insertString.toString();
    }

    /**
     * The insert query
     * @param rec
     * @param into
     * @return the insert query
     */
    public String insertquery(Record rec, String into) {
        return buildInsertString(rec, into);
    }
}
