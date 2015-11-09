package checkpoint.andela.db;

import checkpoint.andela.parser.KeyValue;
import checkpoint.andela.parser.Record;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBWriter {

    public DBWriter() {

    }

    public Connection connectToDB(String dbms, String serverName, String portno, String db, String username, String password ) throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:"+ dbms + "://" + serverName + ":" + portno + "/" + db, buildPropperties(username, password) );
        return connection;
    }

    public Properties buildPropperties(String user, String password) {
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", password);
        return properties;
    }

    public String buildInsertString(Record record, String table) {
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
    public String insertquery(Record rec, String into) {
        return buildInsertString(rec, into);
    }
}
