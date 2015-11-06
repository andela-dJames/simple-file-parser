package checkpoint.andela.db;


import java.sql.Connection;

public class DBWriter {
    private Connection connection;

    public DBWriter(Connection connection) {

        this.connection = connection;
    }

    
}
