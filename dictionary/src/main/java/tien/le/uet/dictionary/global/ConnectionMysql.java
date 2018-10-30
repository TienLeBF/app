package tien.le.uet.dictionary.global;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Class singleton
 *
 * @author tien.le.uet
 *
 */
public class ConnectionMysql implements ConnectionDatabase {
	private static Logger log = Logger.getLogger(ConnectionMysql.class.getName());
	private static ConnectionMysql instance;
	private Properties prop;
	private Connection connection;

	private ConnectionMysql() {
		// Do nothing
	}

	public Connection getConnection() {
		return this.connection;
	}

	public static ConnectionMysql getConnectionSql() {
		if (null == instance) {
			synchronized (ConnectionMysql.class) {
				instance = new ConnectionMysql();
			}
		}

		return instance;
	}

	public void setConnectionDB() throws IOException, ClassNotFoundException, SQLException {
		InputStream inStream = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String fullName = Constant.DIR_FILE_CONFIG + Constant.DATABASE_CONFIG;
			this.prop = new Properties();
			inStream = new FileInputStream(fullName);
			this.prop.load(inStream);

			final String type = this.prop.getProperty(Constant.TYPE);
			final String host = this.prop.getProperty(Constant.HOST);
			final String port = this.prop.getProperty(Constant.PORT);
			final String database = this.prop.getProperty(Constant.DATABASE);
			final String user = this.prop.getProperty(Constant.USER);
			final String password = this.prop.getProperty(Constant.PASSWORD);
			final String url = type + host + ":" + port + "/" + database;
			Connection connection = DriverManager.getConnection(url, user, password);
			if (null == connection) {
				log.info("Can't connect to database");
			} else {
				this.connection = connection;
				log.info("connected to database");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != inStream) {
				inStream.close();
			}
		}
	}
}
