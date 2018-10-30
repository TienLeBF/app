package tien.le.uet.dictionary.global;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tien.le.uet
 *
 */
public interface ConnectionDatabase {

	public Connection getConnection();

	public void setConnectionDB() throws IOException, ClassNotFoundException, SQLException;
}
