package tien.le.uet.characterset.characterset_test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionDB {
	public static Connection connection;
	private static Logger log = Logger.getLogger(ConnectionDB.class);

	private ConnectionDB() {
		connection = this.initilize();
	}

	public static Connection getConnection() {
		if (null == connection) {
			synchronized (ConnectionDB.class) {
				new ConnectionDB();
			}
		}

		return connection;
	}

	private Connection initilize() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File("./etc/database.properties")));
			String classForName = properties.getProperty("class-for-name");
			String url = properties.getProperty("url");
			String databaseName = properties.getProperty("database-name");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			boolean isCheck = this.validateInput(classForName, url, databaseName, username,
					password);
			if (!isCheck) {
				return null;
			}
			Class.forName(classForName);
			String connectionUrl = url.concat(databaseName);
			Connection connection = DriverManager.getConnection(connectionUrl, username, password);
			if (null != connection) {
				log.info("A connection was created");
			}
			return connection;
		} catch (FileNotFoundException e) {
			log.info("Can't find database.properties");
		} catch (IOException e) {
			log.info("Error when read file database.properties");
		} catch (ClassNotFoundException e) {
			log.info("Cant not find driver");
		} catch (Exception e) {
			log.info("Error when creating connection database");
		} finally {
			// Empty
		}

		return null;
	}

	private boolean validateInput(String classForName, String url, String databaseName,
			String username, String password) {
		if (null == classForName || null == url || null == databaseName || null == username
				|| null == password) {
			log.info("database config error when null one or more item");

			return false;
		}

		if (classForName.isEmpty() || url.isEmpty() || databaseName.isEmpty() || username.isEmpty()
				|| password.isEmpty()) {
			log.info("database config error when bank one or more item");

			return false;
		}

		return true;
	}
}
